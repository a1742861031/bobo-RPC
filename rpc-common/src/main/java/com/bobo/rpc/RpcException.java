package com.bobo.rpc;

import com.bobo.rpc.enumeration.RpcError;

/**
 * @author by bobo
 * @Description RPC调用异常
 * @Date 2023/3/1 09:17
 */
public class RpcException extends RuntimeException {
    public RpcException(RpcError rpcError, String detail) {
        super(rpcError.getMessage() + ":" + detail);
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcException(RpcError rpcError) {
        super(rpcError.getMessage());
    }
}
