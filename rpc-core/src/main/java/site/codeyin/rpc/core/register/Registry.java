package site.codeyin.rpc.core.register;

import site.codeyin.rpc.core.config.RegistryConfig;
import site.codeyin.rpc.core.model.ServiceMetaInfo;

import java.util.List;

/**
 * 服务注册接口
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-23 21:06
 */
public interface Registry {
    /**
     * 初始化
     *
     * @param registryConfig 服务注册配置
     */
    void init(RegistryConfig registryConfig);

    /**
     * 注册服务（服务端）
     *
     * @param serviceMetaInfo 服务原信息
     */
    void register(ServiceMetaInfo serviceMetaInfo) throws Exception;

    /**
     * 注销服务（服务端）
     *
     * @param serviceMetaInfo 服务原信息
     */
    void unRegister(ServiceMetaInfo serviceMetaInfo);

    /**
     * 服务发现（获取某服务的所有节点，消费端）
     *
     * @param serviceKey 服务键名
     * @return 服务原信息
     */
    List<ServiceMetaInfo> serviceDiscovery(String serviceKey);

    /**
     * 服务销毁
     */
    void destroy();

    /**
     * 心跳检测（服务端）
     */
    void heartBeat();

    /**
     * 监听（消费端）
     *
     * @param serviceNodeKey 服务节点Key
     */
    void watch(String serviceNodeKey);
}
