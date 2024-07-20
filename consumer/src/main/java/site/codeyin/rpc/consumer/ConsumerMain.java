package site.codeyin.rpc.consumer;

import site.codeyin.rpc.common.model.User;
import site.codeyin.rpc.common.service.UserService;

/**
 * 测试调用
 *
 * @author yinjie
 * @date 2024-07-20 15:59
 */
public class ConsumerMain {
    public static void main(String[] args) {
        UserService userServiceProxy = ProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yinjie");
        System.out.println(userServiceProxy.getUser(user));
    }
}
