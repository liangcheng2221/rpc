package site.codeyin.rpc.core.register;

import site.codeyin.rpc.core.serializer.Serializer;
import site.codeyin.rpc.core.spi.SpiLoader;

/**
 * 服务注册中心工厂
 *
 * @author yinjie
 * @date 2024-07-23 22:28
 */
public class RegistryFactory {
    static {
        SpiLoader.load(Registry.class);
    }
    /**
     * 获取序列化器
     *
     * @param serializerKey 序列化器键 {@link site.codeyin.rpc.core.register.RegistryKeys}
     * @return 序列化器
     */
    public static Registry getRegistry(String serializerKey) {
        return SpiLoader.getInstance(Registry.class, serializerKey);
    }
}
