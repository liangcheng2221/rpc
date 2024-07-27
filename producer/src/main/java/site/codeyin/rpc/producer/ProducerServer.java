package site.codeyin.rpc.producer;

import site.codeyin.rpc.common.service.UserService;
import site.codeyin.rpc.core.RpcApplication;
import site.codeyin.rpc.core.config.RpcConfig;
import site.codeyin.rpc.core.model.ServiceMetaInfo;
import site.codeyin.rpc.core.register.LocalRegistry;
import site.codeyin.rpc.core.register.Registry;
import site.codeyin.rpc.core.register.RegistryFactory;
import site.codeyin.rpc.core.server.HttpServer;
import site.codeyin.rpc.core.server.http.VertXHttpServer;
import site.codeyin.rpc.core.server.tcp.VertxTcpClient;
import site.codeyin.rpc.core.server.tcp.VertxTcpServer;
import site.codeyin.rpc.producer.serviceImpl.UserServiceImpl;

/**
 * 生产者启动
 *
 * @author yinjie
 * @date 2024-07-20 15:31
 */
public class ProducerServer {
    public static void main(String[] args) throws Exception {

        // rpc框架初始化
        RpcApplication.init();
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        Registry registry = RegistryFactory.getRegistry(rpcConfig.getRegistryConfig().getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(UserService.class.getName());
        serviceMetaInfo.setServiceVersion(rpcConfig.getVersion());
        serviceMetaInfo.setServiceHost("localhost");
        serviceMetaInfo.setServicePort(RpcApplication.getRpcConfig().getServerPort());
        registry.register(serviceMetaInfo);
//        LocalInstanceRegistry.register(UserService.class.getName(), new UserServiceImpl());
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 启动 web 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
