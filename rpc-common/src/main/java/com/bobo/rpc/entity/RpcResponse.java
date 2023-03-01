package com.bobo.rpc.entity;

import com.bobo.rpc.enumeration.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author by bobo
 * @Description 返回实体
 * @Date 2023/2/27 19:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RpcResponse<T> implements Serializable {
    /**
     * 响应状态码
     */
    private Integer statusCode;
    /**
     * 响应状态补充信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    /**
     * 成功响应
     */
    public static <T> RpcResponse<T> success(T data) {
        RpcResponse<T> response = new RpcResponse<T>();
        response.setStatusCode(ResponseCode.Success.getCode());
        response.setData(data);
        return response;
    }

    /**
     * 失败响应
     */
    public static <T> RpcResponse<T> fail(ResponseCode code) {
        RpcResponse<T> response = new RpcResponse<T>();
        response.setMessage(code.getMessage());
        response.setStatusCode(code.getCode());
        return response;
    }
}
