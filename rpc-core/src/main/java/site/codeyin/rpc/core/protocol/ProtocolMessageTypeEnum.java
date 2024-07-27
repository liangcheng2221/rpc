package site.codeyin.rpc.core.protocol;

import lombok.Getter;

/**
 * 协议消息的类型枚举
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-27 13:29
 */
@Getter
public enum ProtocolMessageTypeEnum {
    REQUEST(0),
    RESPONSE(1),
    HEART_BEAT(2),
    OTHERS(3);

    private final int key;

    ProtocolMessageTypeEnum(int key) {
        this.key = key;
    }

    /**
     * 根据 key 获取枚举
     *
     * @param key
     * @return
     */
    public static ProtocolMessageTypeEnum getEnumByKey(int key) {
        for (ProtocolMessageTypeEnum anEnum : ProtocolMessageTypeEnum.values()) {
            if (anEnum.key == key) {
                return anEnum;
            }
        }
        return null;
    }
}
