package site.codeyin.rpc.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.codeyin.rpc.core.constant.RpcConstant;
import site.codeyin.rpc.core.serializer.Serializer;
import site.codeyin.rpc.core.serializer.SerializerFactory;
import site.codeyin.rpc.core.serializer.SerializerKeys;

import java.io.Serializable;

/**
 * 请求数据类型
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-20 15:58
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RpcRequest implements Serializable {

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 服务版本
     */
    private String serviceVersion = RpcConstant.DEFAULT_SERVICE_VERSION;


    /**
     * 参数类型列表
     */
    private Class<?>[] parameterTypes;

    /**
     * 参数列表
     */
    private Object[] args;

}
