package site.codeyin.rpc.core.serializer;

import java.io.IOException;

/**
 * 序列化接口
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-20 16:12
 */
public interface Serializer {
    /**
     * 序列化
     *
     * @param object 序列化对象
     * @param <T>    序列化对象的类型
     * @return 返回字节数组对象
     * @throws IOException IO异常
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
     *
     * @param bytes  反序列话的字节数组对象
     * @param tClass 反序列化的字节码对象
     * @param <T>    反序列化的对象类型
     * @return 返回反序列化的对象
     * @throws IOException IO异常
     */
    <T> T deserialize(byte[] bytes, Class<T> tClass) throws IOException;
}
