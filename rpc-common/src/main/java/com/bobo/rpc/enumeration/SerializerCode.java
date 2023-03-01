package com.bobo.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author by bobo
 * @Description 标识序列化和反序列器
 * @Date 2023/3/1 10:58
 */
@AllArgsConstructor
@Getter
public enum SerializerCode {
    JSON(1);
    protected final int code;
}
