package site.codeyin.rpc.producer.server;


import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import site.codeyin.rpc.common.model.RpcRequest;
import site.codeyin.rpc.common.model.RpcResponse;
import site.codeyin.rpc.common.serializer.JdkSerializer;
import site.codeyin.rpc.common.serializer.Serializer;
import site.codeyin.rpc.producer.cache.LocalRegistry;

import java.io.IOException;

/**
 * @author yinjie
 * @date 2024-07-20 15:37
 */
public class HttpServerHandler implements Handler<HttpServerRequest> {
    final Serializer serializer = new JdkSerializer();

    @Override
    public void handle(HttpServerRequest request) {
        request.bodyHandler(buffer -> {
            // 获取请求体的 body 字节数组
            byte[] bytes = buffer.getBytes();
            RpcRequest rpcRequest = null;

            // 序列化请求对象
            try {
                rpcRequest = serializer.deserialize(bytes, RpcRequest.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // 根据请求对象获取目标接口
            Class<?> targetClass = LocalRegistry.get(rpcRequest.getServiceName());


            // 设置响应对象
            RpcResponse rpcResponse = new RpcResponse();
            try {
                // 调用目标方法
                Object responseObject = targetClass.getMethod(rpcRequest.getMethodName(), rpcRequest.getParameterTypes())
                        .invoke(targetClass.newInstance(), rpcRequest.getArgs());
                rpcResponse.setData(responseObject);
                rpcResponse.setDataType(responseObject.getClass().getComponentType());
                rpcResponse.setMessage("ok");
                rpcResponse.setException(null);
            } catch (Exception e) {
                rpcResponse.setData(null);
                rpcResponse.setDataType(null);
                rpcResponse.setMessage("failed");
                rpcResponse.setException(e);
            }

            // 返回响应对象
            doResponse(request, rpcResponse, serializer);
        });
    }

    /**
     * 处理响应请求
     *
     * @param request     请求对象
     * @param rpcResponse 返回响应对象
     * @param serializer  序列化对象
     */
    private void doResponse(HttpServerRequest request, RpcResponse rpcResponse, Serializer serializer) {
        HttpServerResponse httpServerResponse = request.response();
        try {
            // 序列化
            byte[] serialized = serializer.serialize(rpcResponse);
            httpServerResponse.end(Buffer.buffer(serialized));
        } catch (IOException e) {
            e.printStackTrace();
            httpServerResponse.end(Buffer.buffer());
        }
    }
}
