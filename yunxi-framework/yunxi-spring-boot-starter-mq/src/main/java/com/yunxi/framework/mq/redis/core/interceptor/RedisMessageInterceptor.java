package com.yunxi.framework.mq.redis.core.interceptor;

import com.yunxi.framework.mq.redis.core.message.AbstractRedisMessage;

/**
 * <p>
 * {@link AbstractRedisMessage} 消息拦截器
 * </p>
 * 通过拦截器，作为插件机制，实现拓展。
 * 例如说，多租户场景下的 MQ 消息处理
 *
 * @author lidy
 * @since 2024-05-06
 */
public interface RedisMessageInterceptor {

    default void sendMessageBefore(AbstractRedisMessage message) {
    }

    default void sendMessageAfter(AbstractRedisMessage message) {
    }

    default void consumeMessageBefore(AbstractRedisMessage message) {
    }

    default void consumeMessageAfter(AbstractRedisMessage message) {
    }

}
