package site.codeyin.rpc.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author yinjie
 * @date 2024-07-20 15:26
 */
@Data
public class User implements Serializable {

    private String name;
}

