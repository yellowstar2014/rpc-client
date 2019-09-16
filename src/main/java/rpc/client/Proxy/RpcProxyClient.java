package rpc.client.Proxy;

import java.lang.reflect.Proxy;

/**
 * @author yellow
 * @date 2019/9/12 17:23
 * 温馨提醒:
 * 代码千万行，
 * 注释第一行。
 * 命名不规范，
 * 同事两行泪。
 */
public class RpcProxyClient {
    //动态代理
    public <T> T clientProxy(final Class<T> interfaceClass, final String host, final int port) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new RemotInvocationHandler(host, port));
    }
}
