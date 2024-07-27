package site.codeyin.rpc.consumer;

import site.codeyin.rpc.common.model.User;
import site.codeyin.rpc.common.service.UserService;
import site.codeyin.rpc.core.RpcApplication;
import site.codeyin.rpc.core.proxy.ProxyFactory;


/**
 * 测试调用
 *
 * @author yinjie
 * @date 2024-07-20 15:59
 */
public class ConsumerMain {
    public static void main(String[] args) {
        RpcApplication.init();
        UserService userService = ProxyFactory.getProxy(UserService.class);
        System.out.println(userService.getUser(new User()));
    }
}
