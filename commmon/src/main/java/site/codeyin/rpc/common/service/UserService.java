package site.codeyin.rpc.common.service;

import site.codeyin.rpc.common.model.User;

/**
 * 用户服务接口
 *
 * @author yinjie
 * @date 2024-07-20 15:26
 */
public interface UserService {

    /**
     * 获取用户
     *
     * @param user 用户对象
     * @return 返回用户对象
     */
    User getUser(User user);

}
