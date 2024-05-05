package com.yunxi.framework.apilog.config;

import com.yunxi.module.infra.api.logger.ApiAccessLogApi;
import com.yunxi.module.infra.api.logger.ApiErrorLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * API 日志使用到 Feign 的配置项
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@AutoConfiguration
@EnableFeignClients(clients = {ApiAccessLogApi.class, // 主要是引入相关的 API 服务
        ApiErrorLogApi.class})
public class YunxiApiLogRpcAutoConfiguration {
}
