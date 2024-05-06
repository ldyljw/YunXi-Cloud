package com.yunxi.framework.mq.redis.core.message;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Redis 消息抽象基类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Data
public abstract class AbstractRedisMessage {

    /**
     * 头
     */
    private Map<String, String> headers = new HashMap<>();

    public String getHeader(String key) {
        return headers.get(key);
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

}
