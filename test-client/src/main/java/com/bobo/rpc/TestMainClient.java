package com.bobo.rpc;

import com.bobo.client.RpcClientProxy;

/**
 * @author by bobo
 * @Description TODO
 * @Date 2023/2/27 20:39
 */
public class TestMainClient {
    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy("localhost", 10000);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject hello = new HelloObject(12, "this is a message");
        String res = helloService.hello(hello);
        System.out.println(res);
    }
}
