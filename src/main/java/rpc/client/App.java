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
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IDemoService demoService = rpcProxyClient.clientProxy(IDemoService.class,"localhost",8081);

        System.out.println( "###"+demoService.welcomeFun("yellow"));
    }
}
