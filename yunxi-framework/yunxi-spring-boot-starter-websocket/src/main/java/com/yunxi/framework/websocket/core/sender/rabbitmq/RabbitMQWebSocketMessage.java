package com.yunxi.framework.websocket.core.sender.rabbitmq;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * public LocalWebSocketMessageSender(WebSocketSessionManager sessionManager) {         super(sessionManager);     }
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Data
public class RabbitMQWebSocketMessage implements Serializable {

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
