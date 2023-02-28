package com.bobo.rpc;

import com.bobo.server.RpcServer;

/**
 * @author by bobo
 * @Description 服务端测试
 * @Date 2023/2/27 20:44
 */
public class TestMainServer {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        HelloService helloService = new HelloServiceImpl();
        rpcServer.register(helloService, 10001);
    }
}
