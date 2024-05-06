package com.yunxi.framework.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 * Cache 配置属性
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@ConfigurationProperties(prefix = "yunxi.cache")
@Data
@Validated
public class YunxiCacheProperties {

    /**
     * {@link #redisScanBatchSize} 默认值
     */
    private static final Integer REDIS_SCAN_BATCH_SIZE_DEFAULT = 30;

    /**
     * redis scan 一次返回数量
     */
    private Integer redisScanBatchSize = REDIS_SCAN_BATCH_SIZE_DEFAULT;

}
