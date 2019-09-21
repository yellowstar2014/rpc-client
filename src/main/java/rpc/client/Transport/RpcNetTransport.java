package rpc.client.Transport;

import demo.rpc.request.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author yellow
 * @date 2019/9/12 17:43
 * 温馨提醒:
 * 代码千万行，
 * 注释第一行。
 * 命名不规范，
 * 同事两行泪。
 */
public class RpcNetTransport {
    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket() throws Exception{
        System.out.println("开始构建一个client端");
        Socket socket = new Socket(host,port);
        return  socket;
    }

    /**
     * 发送数据
     * @param request 数据
     * @return
     */
    public Object send(RpcRequest request){
        Socket socket=null;
        ObjectInputStream objectInputStream =null;
        ObjectOutputStream objectOutputStream=null;
        Object result=null;
        try {
            socket=newSocket();
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);//给服务端发送数据
            objectOutputStream.flush();
            System.out.println("向server端（"+host+":"+port+"）发起远程服务请求："+request.toString());
            //得到服务端的返回结果
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            result =objectInputStream.readObject();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (objectInputStream!=null){
                try{
                    objectInputStream.close();
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            if (objectOutputStream!=null){
                try{
                    objectOutputStream.close();
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }

        return  result;
    }
}
