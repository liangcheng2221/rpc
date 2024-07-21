package site.codeyin.rpc.core;

import lombok.extern.slf4j.Slf4j;
import site.codeyin.rpc.core.config.RpcConfig;
import site.codeyin.rpc.core.constant.RpcConstant;
import site.codeyin.rpc.core.utils.ConfigUtils;

/**
 * Rpc框架应用
 *
 * @author yinjie
 * @date 2024-07-21 10:44
 */
@Slf4j
public class RpcApplication {
    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化
     *
     * @param rpcConfig rpc的配置类参数
     */
    public static void init(RpcConfig rpcConfig) {
        RpcApplication.rpcConfig = rpcConfig;
        log.info("rpc init, config = {}", rpcConfig);
    }

    /**
     * 框架初始化
     */
    public static void init() {
        RpcConfig rpcConfig = null;
        try {
            rpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            rpcConfig = new RpcConfig();
        }
        init(rpcConfig);
    }

    /**
     * 获取配置类（双检索机制）
     *
     * @return 返回配置类
     */
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized (RpcApplication.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }

}
