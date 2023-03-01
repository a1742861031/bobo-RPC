package com.bobo.serializer;

/**
 * @author by bobo
 * @Description 序列化器接口
 * @Date 2023/3/1 10:40
 */
public interface CommonSerializer {
    /**
     * 序列化
     *
     * @param obj 对象
     * @return byte数组
     */
    byte[] serialize(Object obj);

    /**
     * 反序列化
     *
     * @param bytes byte数组
     * @param clazz .class
     * @return 对象
     */
    Object deserialize(byte[] bytes, Class<?> clazz);

    /**
     * 获取序列化器标识code
     *
     * @return 返回code
     */
    int getCode();

    /**
     * 通过code获取序列化器
     *
     * @param code code
     * @return 序列化器
     */
    static CommonSerializer getByCode(int code) {
        switch (code) {
            case 1:
                return new JsonSerializer();
            default:
                return null;
        }
    }
}
