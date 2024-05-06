package com.yunxi.framework.tenant.config;

import com.yunxi.framework.tenant.core.rpc.TenantRequestInterceptor;
import com.yunxi.system.api.tenant.TenantApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * 多租户远程调用 RPC 配置类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@AutoConfiguration
// 允许使用 yunxi.tenant.enable=false 禁用多租户
@ConditionalOnProperty(prefix = "yunxi.tenant", value = "enable", matchIfMissing = true)
@EnableFeignClients(clients = TenantApi.class) // 主要是引入相关的 API 服务
public class YunxiTenantRpcAutoConfiguration {

    @Bean
    public TenantRequestInterceptor tenantRequestInterceptor() {
        return new TenantRequestInterceptor();
    }

}
