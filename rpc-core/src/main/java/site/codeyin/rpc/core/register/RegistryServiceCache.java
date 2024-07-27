package site.codeyin.rpc.core.register;

import site.codeyin.rpc.core.model.ServiceMetaInfo;

import java.util.List;

/**
 * 服务注册本地缓存
 *
 * @author yinjie
 * @date 2024-07-23 22:09
 */
public class RegistryServiceCache {
    /**
     * 服务缓存
     */
    List<ServiceMetaInfo> serviceCache;

    /**
     * 写缓存
     *
     * @param newServiceCache 服务元数据列表（每次只能一批一批的写）
     */
    void writeCache(List<ServiceMetaInfo> newServiceCache) {
        this.serviceCache = newServiceCache;
    }

    /**
     * 读缓存（读取本地服务地址列表）
     *
     * @return 返回服务元数据列表
     */
    List<ServiceMetaInfo> readCache() {
        return this.serviceCache;
    }

    /**
     * 清空缓存
     */
    void clearCache() {
        this.serviceCache = null;
    }
}
