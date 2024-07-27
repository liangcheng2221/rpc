package site.codeyin.rpc.core.protocol;

/**
 * 协议常量
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-27 13:15
 */
public interface ProtocolConstant {
    /**
     * 消息头长度
     */
    int MESSAGE_HEADER_LENGTH = 17;

    /**
     * 协议魔数
     */
    byte PROTOCOL_MAGIC = 0x1;

    /**
     * 协议版本号
     */
    byte PROTOCOL_VERSION = 0x1;
}
