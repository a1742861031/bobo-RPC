package com.bobo;

import com.bobo.rpc.entity.RpcRequest;

/**
 * @author by bobo
 * @Description RPC 客户端
 * @Date 2023/3/1 10:21
 */
public interface RpcClient {
    Object sendRequest(RpcRequest rpcRequest);
}
