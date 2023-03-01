package com.bobo;

import com.bobo.rpc.entity.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author by bobo
 * @Description 客户端RPC代理类
 * @Date 2023/3/1 14:15
 */
public class NettyRpcClientProxy implements InvocationHandler {
    private final Logger logger = LoggerFactory.getLogger(NettyRpcClientProxy.class);
    private final RpcClient rpcClient;

    public NettyRpcClientProxy(RpcClient client) {
        this.rpcClient = client;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("调用方法:{}#{}", method.getDeclaringClass().getName(), method.getName());
        RpcRequest rpcRequest = new RpcRequest(method.getDeclaringClass().getName(), method.getName(), args, method.getParameterTypes());
        return rpcClient.sendRequest(rpcRequest);
    }

    @SuppressWarnings("unchecked")
    public <T> T gerProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, this);
    }
}
