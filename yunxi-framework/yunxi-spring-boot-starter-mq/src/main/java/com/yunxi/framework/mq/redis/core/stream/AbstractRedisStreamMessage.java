package com.yunxi.framework.mq.redis.core.stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yunxi.framework.mq.redis.core.message.AbstractRedisMessage;

/**
 * <p>
 * Redis Stream Message 抽象类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public abstract class AbstractRedisStreamMessage extends AbstractRedisMessage {

    /**
     * 获得 Redis Stream Key，默认使用类名
     *
     * @return Channel
     */
    @JsonIgnore // 避免序列化
    public String getStreamKey() {
        return getClass().getSimpleName();
    }

}
