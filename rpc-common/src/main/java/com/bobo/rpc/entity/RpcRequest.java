package com.bobo.rpc.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author by bobo
 * @Description 传输的实体类
 * @Date 2023/2/27 19:35
 */
@Data
@Builder
public class RpcRequest implements Serializable {
    /**
     * 待调用接口名称
     */
    private String interfaceName;
    /**
     * 待调用方法名称
     */
    private String methodName;
    /**
     * 调用方法的参数
     */
    private Object[] parameters;
    /**
     * 调用方法的参数类型
     */
    private Class<?>[] paramTypes;
}