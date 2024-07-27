package site.codeyin.rpc.core.proxy;

import java.lang.reflect.Proxy;

/**
 * 反射工厂：获取代理对象
 *
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-20 15:49
 */
public class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T getProxy(Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass}, new ProxyInvocationHandler(interfaceClass));
    }
}
