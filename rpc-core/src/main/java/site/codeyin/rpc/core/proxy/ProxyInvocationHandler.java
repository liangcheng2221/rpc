package site.codeyin.rpc.core.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import site.codeyin.rpc.core.RpcApplication;
import site.codeyin.rpc.core.model.RpcRequest;
import site.codeyin.rpc.core.model.RpcResponse;
import site.codeyin.rpc.core.serializer.JdkSerializer;
import site.codeyin.rpc.core.serializer.Serializer;
import site.codeyin.rpc.core.serializer.SerializerFactory;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 反射调用
 *
 * @author yinjie
 * @date 2024-07-20 15:54
 */
public class ProxyInvocationHandler implements InvocationHandler {
    // 服务实例类对象
    private final Class<?> interfaceClass;
    // 序列化器
    private final Serializer serializer = SerializerFactory.getSerializer(RpcApplication.getRpcConfig().getSerializer());

    public ProxyInvocationHandler(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 构建请求参数对象
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(interfaceClass.getName())
                .parameterTypes(method.getParameterTypes())
                .args(args)
                .methodName(method.getName())
                .build();

        // 发起请求
        HttpResponse response = HttpRequest.post("http://localhost:8080")
                .body(serializer.serialize(rpcRequest))
                .execute();

        // 反序列化响应对象
        RpcResponse rpcResponse = serializer.deserialize(response.bodyBytes(), RpcResponse.class);

        if (rpcResponse.getException() != null) {
            throw rpcResponse.getException();
        }

        return rpcResponse.getData();
    }
}
