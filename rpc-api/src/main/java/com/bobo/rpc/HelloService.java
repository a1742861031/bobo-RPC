package com.bobo.rpc;

/**
 * @author by bobo
 * @Description 测试Service
 * @Date 2023/2/27 19:29
 */
public interface HelloService {
    /**
     * 测试方法
     *
     * @param helloObject 测试对象
     * @return string
     */
    String hello(HelloObject helloObject);
}
