package com.yunxi.framework.operatelog.config;

import com.yunxi.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * OperateLog 使用到 Feign 的配置项
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@AutoConfiguration
@EnableFeignClients(clients = {OperateLogApi.class}) // 主要是引入相关的 API 服务
public class YunxiOperateLogRpcAutoConfiguration {
}
