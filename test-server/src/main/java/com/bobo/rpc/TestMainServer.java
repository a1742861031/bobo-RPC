package com.bobo.rpc;

import com.bobo.netty.server.NettyServer;
import com.bobo.registry.DefaultServiceRegistry;
import com.bobo.registry.ServerRegistry;
import com.bobo.socket.server.RpcServer;

/**
 * @author by bobo
 * @Description 服务端测试
 * @Date 2023/2/27 20:44
 */
public class TestMainServer {
    public static void main(String[] args) {
//        testSocketRpc();
        testNettyRpc();
    }

    private static void testNettyRpc() {
        HelloService helloService = new HelloServiceImpl();
        ServerRegistry serverRegistry = new DefaultServiceRegistry();
        serverRegistry.registry(helloService);
        NettyServer nettyServer = new NettyServer(serverRegistry);
        nettyServer.start(10000);
    }


    private static void testSocketRpc() {
        HelloService helloService = new HelloServiceImpl();
        ServerRegistry serverRegistry = new DefaultServiceRegistry();
        serverRegistry.registry(helloService);
        RpcServer rpcServer = new RpcServer(serverRegistry);
        rpcServer.start(10000);
    }
}
