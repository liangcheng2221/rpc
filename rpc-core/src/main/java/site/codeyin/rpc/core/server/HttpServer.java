package site.codeyin.rpc.core.server;

/**
 * 服务接口
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-20 15:33
 */
public interface HttpServer {
    /**
     * 启动http服务
     *
     * @param port 启动服务端端口
     */
    void doStart(int port);
}
