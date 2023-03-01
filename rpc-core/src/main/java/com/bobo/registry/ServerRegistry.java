package com.bobo.registry;

/**
 * @author by bobo
 * @Description 服务
 * @Date 2023/2/28 09:46
 */
public interface ServerRegistry {
    /**
     * 服务注册
     *
     * @param service 注册服务
     * @param <T>     泛型
     */
    <T> void registry(T service);

    /**
     * 从服务注册表中获取
     *
     * @param serviceName 服务名
     * @return 服务
     */
    Object getService(String serviceName);
}
