package rpc.client;

import demo.rpc.service.IDemoService;
import rpc.client.Proxy.RpcProxyClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "The project is RPC framework" );
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IDemoService demoService = rpcProxyClient.clientProxy(IDemoService.class,"127.0.0.1",8081);

        System.out.println( "远程服务返回结果："+demoService.welcomeFun("yellow"));
    }
}
