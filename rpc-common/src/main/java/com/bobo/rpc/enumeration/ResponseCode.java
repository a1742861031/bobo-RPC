package com.bobo.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author by bobo
 * @Description 响应状态码
 * @Date 2023/2/27 19:40
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {
    /**
     * 想用状态码及补充的信息
     */
    Success(200, "方法调用成功"),
    FAIL(500, "调用方法失败"),
    METHOD_NOT_FOUND(500, "未找到指定方法"),
    CLASS_NOT_FOUND(500, "未找到指定类");
    private final int code;
    private final String message;

}
