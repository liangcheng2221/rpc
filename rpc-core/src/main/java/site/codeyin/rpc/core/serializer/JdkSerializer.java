package site.codeyin.rpc.core.serializer;


import java.io.*;

/**
 * JDK序列化器
 *
 * @author yinjie
 * @date 2024-07-20 16:12
 */
public class JdkSerializer implements Serializer {
    /**
     * 序列化
     *
     * @param object 序列化对象
     * @param <T>    序列化对象的类型
     * @return 返回字节数组对象
     * @throws IOException IO异常
     */
    @Override
    public <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return outputStream.toByteArray();
    }

    /**
     * 反序列化
     *
     * @param bytes  反序列话的字节数组对象
     * @param tClass 反序列化的字节码对象
     * @param <T>    反序列化的对象类型
     * @return 返回反序列化的对象
     * @throws IOException IO异常
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(byte[] bytes, Class<T> tClass) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return (T) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("反序列化失败");
        }
    }
}
