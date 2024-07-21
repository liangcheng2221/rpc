package site.codeyin.rpc.core.serializer;

import site.codeyin.rpc.core.spi.SpiLoader;


/**
 * 序列化工厂
 *
 * @author yinjie
 * @date 2024-07-21 13:37
 */
public class SerializerFactory {

    static {
        SpiLoader.loadAll();
    }


    /**
     * 获取序列化器
     *
     * @param serializerKey 序列化器键
     * @return 序列化器
     */
    public static Serializer getSerializer(String serializerKey) {
        return SpiLoader.getInstance(Serializer.class, serializerKey);
    }
}
