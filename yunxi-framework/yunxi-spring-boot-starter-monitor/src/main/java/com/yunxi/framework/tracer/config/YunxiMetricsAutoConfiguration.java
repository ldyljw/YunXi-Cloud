package com.yunxi.framework.tracer.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * Metrics 配置类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@AutoConfiguration
@ConditionalOnClass({MeterRegistryCustomizer.class})
// 允许使用 yunxi.metrics.enable=false 禁用 Metrics
@ConditionalOnProperty(prefix = "yunxi.metrics", value = "enable", matchIfMissing = true)
public class YunxiMetricsAutoConfiguration {

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags(
            @Value("${spring.application.name}") String applicationName) {
        return registry -> registry.config().commonTags("application", applicationName);
    }

}
