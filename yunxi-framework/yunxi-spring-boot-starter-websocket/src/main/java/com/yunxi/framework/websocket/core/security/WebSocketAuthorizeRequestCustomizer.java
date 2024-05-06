package com.yunxi.framework.websocket.core.security;

import com.yunxi.framework.security.config.AuthorizeRequestsCustomizer;
import com.yunxi.framework.websocket.config.WebSocketProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * <p>
 * WebSocket 的权限自定义
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@RequiredArgsConstructor
public class WebSocketAuthorizeRequestCustomizer extends AuthorizeRequestsCustomizer {

    private final WebSocketProperties webSocketProperties;

    @Override
    public void customize(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry) {
        registry.antMatchers(webSocketProperties.getPath()).permitAll();
    }

}
