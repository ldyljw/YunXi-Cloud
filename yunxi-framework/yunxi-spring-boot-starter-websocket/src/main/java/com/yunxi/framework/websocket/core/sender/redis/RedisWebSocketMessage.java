package com.yunxi.framework.websocket.core.sender.redis;

import com.yunxi.framework.mq.redis.core.pubsub.AbstractRedisChannelMessage;
import lombok.Data;

/**
 * <p>
 * private final RabbitMQWebSocketMessageSender rabbitMQWebSocketMessageSender;      @RabbitHandler     public void onMessage(RabbitMQWebSocketMessage message) {         rabbitMQWebSocketMessageSender.send(message.getSessionId(),                 message.getUserType(), message.getUserId(),                 message.getMessageType(), message.getMessageContent());     }
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Data
public class RedisWebSocketMessage extends AbstractRedisChannelMessage {

    /**
     * Session 编号
     */
    private String sessionId;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 消息类型
     */
    private String messageType;
    /**
     * 消息内容
     */
    private String messageContent;

}
