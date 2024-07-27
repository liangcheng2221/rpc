package site.codeyin.rpc.core.config;

import lombok.Data;
import site.codeyin.rpc.core.register.RegistryKeys;

/**
 * 注册中心配置对象（可以使用自定义注册服务）
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-23 21:01
 */
@Data
public class RegistryConfig {
    /**
     * 注册中心类别
     */
    private String registry = RegistryKeys.ZOOKEEPER;

    /**
     * 注册中心地址
     */
    private String address = "localhost:2181";

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 超时时间（单位毫秒）
     */
    private Long timeout = 10000L;
}
