package site.codeyin.rpc.consumer;

import site.codeyin.rpc.core.RpcApplication;
import site.codeyin.rpc.core.config.RpcConfig;
import site.codeyin.rpc.core.serializer.SerializerFactory;
import site.codeyin.rpc.core.serializer.SerializerKeys;

/**
 * 测试调用
 *
 * @author yinjie
 * @date 2024-07-20 15:59
 */
public class ConsumerMain {
    public static void main(String[] args) {
        RpcConfig config = new RpcConfig();
        config.setSerializer(SerializerKeys.HESSIAN);
        RpcApplication.init(config);
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        System.out.println(SerializerFactory.getSerializer(rpcConfig.getSerializer()));
        System.out.println(rpcConfig);
    }
}
