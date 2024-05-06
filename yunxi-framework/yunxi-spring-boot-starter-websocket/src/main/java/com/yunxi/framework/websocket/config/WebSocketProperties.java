package com.yunxi.framework.websocket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * WebSocket 配置属性
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@ConfigurationProperties(prefix = "yunxi.websocket")
@Data
@Validated
public class WebSocketProperties {

    /**
     * WebSocket 的连接路径
     */
    @NotEmpty(message = "WebSocket 的连接路径不能为空")
    private String path = "/ws";

    /**
     * 消息发送器的类型
     * <p>
     * 可选值：local、redis、rocketmq、kafka、rabbitmq
     */
    @NotNull(message = "WebSocket 的消息发送者不能为空")
    private String senderType = "local";

}
