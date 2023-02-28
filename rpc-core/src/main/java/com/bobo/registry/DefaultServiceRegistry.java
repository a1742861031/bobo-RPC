package com.bobo.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by bobo
 * @Description 服务注册
 * @Date 2023/2/28 09:50
 */
public class DefaultServiceRegistry implements ServerRegistry {
    private static final Logger logger = LoggerFactory.getLogger(DefaultServiceRegistry.class);
    private final Map<String, Object> serviceMap = new ConcurrentHashMap<>();
    private final Set<String> registeredService = ConcurrentHashMap.newKeySet();



    @Override
    public <T> void registry(T service) {

    }

    @Override
    public Object getService(String serviceName) {
        return null;
    }
}
