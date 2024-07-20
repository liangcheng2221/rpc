package site.codeyin.rpc.producer;

import site.codeyin.rpc.common.service.UserService;
import site.codeyin.rpc.producer.cache.LocalRegistry;
import site.codeyin.rpc.producer.server.HttpServer;
import site.codeyin.rpc.producer.server.VertXHttpServer;
import site.codeyin.rpc.producer.serviceImpl.UserServiceImpl;

/**
 * 生产者启动
 *
 * @author yinjie
 * @date 2024-07-20 15:31
 */
public class ProducerServer {
    public static void main(String[] args) {
//        LocalInstanceRegistry.register(UserService.class.getName(), new UserServiceImpl());
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 启动 web 服务
        HttpServer httpServer = new VertXHttpServer();
        httpServer.doStart(8080);
    }
}
