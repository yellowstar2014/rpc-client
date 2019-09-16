package rpc.client.Proxy;

import demo.rpc.request.RpcRequest;
import rpc.client.RpcNetTransport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yellow
 * @date 2019/9/12 17:32
 * 温馨提醒:
 * 代码千万行，
 * 注释第一行。
 * 命名不规范，
 * 同事两行泪。
 */
public class RemotInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemotInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin:"+host+"->"+port);
        //构建需要访问的服务端---类的方法
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParams(args);
        //发起socket链接服务端，并发送数据
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host,port);
        Object result = rpcNetTransport.send(request);

        return result;
    }
}
