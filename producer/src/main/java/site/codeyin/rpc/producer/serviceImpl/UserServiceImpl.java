package site.codeyin.rpc.producer.serviceImpl;

import site.codeyin.rpc.common.model.User;
import site.codeyin.rpc.common.service.UserService;

/**
 * UserService实现类
 *
 * @author yinjie
 * @date 2024-07-20 16:03
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("服务端执行getUser方法");
        return user;
    }
}
