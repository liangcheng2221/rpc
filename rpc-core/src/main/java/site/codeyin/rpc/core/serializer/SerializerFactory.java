package site.codeyin.rpc.core.serializer;

import site.codeyin.rpc.core.spi.SpiLoader;


/**
 * 序列化工厂
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-21 13:37
 */
public class SerializerFactory {

    static {
        SpiLoader.load(Serializer.class);
    }


    /**
     * 获取序列化器
     *
     * @param serializerKey 序列化器键 {@link site.codeyin.rpc.core.serializer.SerializerKeys}
     * @return 序列化器
     */
    public static Serializer getSerializer(String serializerKey) {
        return SpiLoader.getInstance(Serializer.class, serializerKey);
    }
}
