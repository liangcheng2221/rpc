package site.codeyin.rpc.core.config;

import lombok.Data;
import site.codeyin.rpc.core.serializer.SerializerKeys;

/**
 * rpc相关配置类
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-21 10:34
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "jie-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;

    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 注冊中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();


}
