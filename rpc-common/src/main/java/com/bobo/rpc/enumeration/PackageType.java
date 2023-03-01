package com.bobo.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author by bobo
 * @Description TODO
 * @Date 2023/3/1 12:49
 */
@AllArgsConstructor
@Getter
public enum PackageType {
    /**
     * 请求包
     */
    Request_PACK(0),
    /**
     * 响应包
     */
    Response_PACK(1);
    private final int code;
}
