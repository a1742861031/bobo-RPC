package com.bobo.serializer;

import com.bobo.rpc.entity.RpcRequest;
import com.bobo.rpc.enumeration.SerializerCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author by bobo
 * @Description Json序列化器
 * @Date 2023/3/1 10:43
 */
public class JsonSerializer implements CommonSerializer {
    private static final Logger logger = LoggerFactory.getLogger(JsonSerializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(Object obj) {
        try {
            return objectMapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            logger.error("序列化发生错误:{}", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object deserialize(byte[] bytes, Class<?> clazz) {
        try {
            Object o = objectMapper.readValue(bytes, clazz);
            if (o instanceof RpcRequest) {
                o = handleRequest(o);
            }
            return o;
        } catch (IOException e) {
            logger.error("反序列化时发生错误");
            e.printStackTrace();
            return null;
        }
    }

    private Object handleRequest(Object object) throws IOException {
        RpcRequest rpcRequest = (RpcRequest) object;
        for (int i = 0; i < rpcRequest.getParameters().length; i++) {
            Class<?> clazz = rpcRequest.getParamTypes()[i];
            if (!clazz.isAssignableFrom(rpcRequest.getParameters()[i].getClass())) {
                byte[] bytes = objectMapper.writeValueAsBytes(rpcRequest.getParameters()[i]);
                rpcRequest.getParameters()[i] = objectMapper.readValue(bytes, clazz);
            }
        }
        return rpcRequest;
    }

    @Override
    public int getCode() {
        return SerializerCode.JSON.getCode();
    }
}
