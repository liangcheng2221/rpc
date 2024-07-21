package site.codeyin.rpc.producer;

import site.codeyin.rpc.common.service.UserService;
import site.codeyin.rpc.core.RpcApplication;
import site.codeyin.rpc.core.register.LocalRegistry;
import site.codeyin.rpc.core.server.HttpServer;
import site.codeyin.rpc.core.server.VertXHttpServer;
import site.codeyin.rpc.producer.serviceImpl.UserServiceImpl;

/**
 * 生产者启动
 *
 * @author yinjie
 * @date 2024-07-20 15:31
 */
public class ProducerServer {
    public static void main(String[] args) {

        // rpc框架初始化
        RpcApplication.init();

//        LocalInstanceRegistry.register(UserService.class.getName(), new UserServiceImpl());
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 启动 web 服务
        HttpServer httpServer = new VertXHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
