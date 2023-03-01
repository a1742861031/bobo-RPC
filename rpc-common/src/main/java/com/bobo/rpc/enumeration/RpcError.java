package com.bobo.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author by bobo
 * @Description RPC远程调用失败
 * @Date 2023/3/1 09:22
 */
@AllArgsConstructor
@Getter
public enum RpcError {
    SERVICE_INVOCATION_FAILURE("调用服务出现失败"),
    SERVICE_NOT_FOUND("找不到对应服务"),
    SERVICE_NOT_IMPLEMENT_ANY_INTERFACE("注册的服务未实现接口"),
    UNKNOWN_PROTOCOL("不识别协议包"),
    UNKNOWN_SERIALIZER("不识别的序列化器");
    private final String message;
}
