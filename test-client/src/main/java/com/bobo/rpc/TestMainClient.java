package com.bobo.rpc;

import com.bobo.NettyRpcClientProxy;
import com.bobo.netty.client.NettyClient;
import com.bobo.socket.client.RpcClientProxy;

/**
 * @author by bobo
 * @Description TODO
 * @Date 2023/2/27 20:39
 */
public class TestMainClient {
    public static void main(String[] args) {
//        testSocketRpc();
        testNettyRpc();
    }

    private static void testNettyRpc() {
        NettyClient client = new NettyClient("localhost", 10000);
        NettyRpcClientProxy nettyRpcClientProxy = new NettyRpcClientProxy(client);
        HelloService service = nettyRpcClientProxy.gerProxy(HelloService.class);
        HelloObject hello = new HelloObject(1, "hello");
        System.out.println(service.hello(hello));
    }

    private static void testSocketRpc() {
        RpcClientProxy rpcClientProxy = new RpcClientProxy("localhost", 10000);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject hello = new HelloObject(12, "this is a message");
        String res = helloService.hello(hello);
        System.out.println(res);
    }
}
