package com.yunxi.framework.websocket.core.sender.local;

import com.yunxi.framework.websocket.core.sender.AbstractWebSocketMessageSender;
import com.yunxi.framework.websocket.core.sender.WebSocketMessageSender;
import com.yunxi.framework.websocket.core.session.WebSocketSessionManager;

/**
 * <p>
 * 本地的 {@link WebSocketMessageSender} 实现类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public class LocalWebSocketMessageSender extends AbstractWebSocketMessageSender {

    public LocalWebSocketMessageSender(WebSocketSessionManager sessionManager) {
        super(sessionManager);
    }

}
