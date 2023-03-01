package com.bobo.rpc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author by bobo
 * @Description 测试服务实现类
 * @Date 2023/2/27 19:31
 */
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(HelloObject helloObject) {
        log.info("接收到:{}", helloObject.getMessage());
        return "这是调用的返回值,id=" + helloObject.getId();
    }
}
