package site.codeyin.rpc.core.protocol;

import io.vertx.core.buffer.Buffer;
import site.codeyin.rpc.core.serializer.Serializer;
import site.codeyin.rpc.core.serializer.SerializerFactory;

import java.io.IOException;

/**
 * 协议消息编码器
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-27 13:44
 */
public class ProtocolMessageEncoder {
    /**
     * 编码
     *
     * @param protocolMessage 协议消息体
     * @return {@link Buffer}
     */
    public static Buffer encode(ProtocolMessage<?> protocolMessage) throws IOException {
        if (protocolMessage == null || protocolMessage.getHeader() == null) {
            return Buffer.buffer();
        }
        ProtocolMessage.Header header = protocolMessage.getHeader();
        // 依次向缓冲区写入字节
        Buffer buffer = Buffer.buffer();
        buffer.appendByte(header.getMagic());
        buffer.appendByte(header.getVersion());
        buffer.appendByte(header.getSerializer());
        buffer.appendByte(header.getType());
        buffer.appendByte(header.getStatus());
        buffer.appendLong(header.getRequestId());
        // 获取序列化器
        ProtocolMessageSerializerEnum serializerEnum = ProtocolMessageSerializerEnum.getEnumByKey(header.getSerializer());
        if (serializerEnum == null) {
            throw new RuntimeException("序列化协议不存在");
        }
        Serializer serializer = SerializerFactory.getSerializer(serializerEnum.getValue());
        byte[] bodyBytes = serializer.serialize(protocolMessage.getBody());
        // 写入 body 长度和数据
        buffer.appendInt(bodyBytes.length);
        buffer.appendBytes(bodyBytes);
        return buffer;
    }
}
