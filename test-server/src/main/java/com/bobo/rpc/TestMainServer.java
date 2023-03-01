package com.bobo.rpc;

import com.bobo.registry.DefaultServiceRegistry;
import com.bobo.registry.ServerRegistry;
import com.bobo.server.RpcServer;

/**
 * @author by bobo
 * @Description 服务端测试
 * @Date 2023/2/27 20:44
 */
public class TestMainServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServerRegistry serverRegistry = new DefaultServiceRegistry();
        serverRegistry.registry(helloService);
        RpcServer rpcServer = new RpcServer(serverRegistry);
        rpcServer.start(10000);
    }
}
