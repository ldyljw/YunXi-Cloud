package com.yunxi.framework.security.config;

import com.yunxi.framework.security.core.rpc.LoginUserRequestInterceptor;
import com.yunxi.system.api.oauth2.OAuth2TokenApi;
import com.yunxi.system.api.permission.PermissionApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * Security 使用到 Feign 的配置项
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@AutoConfiguration
@EnableFeignClients(clients = {OAuth2TokenApi.class,// 主要是引入相关的 API 服务
        PermissionApi.class})
public class YunxiSecurityRpcAutoConfiguration {

    @Bean
    public LoginUserRequestInterceptor loginUserRequestInterceptor() {
        return new LoginUserRequestInterceptor();
    }

}
