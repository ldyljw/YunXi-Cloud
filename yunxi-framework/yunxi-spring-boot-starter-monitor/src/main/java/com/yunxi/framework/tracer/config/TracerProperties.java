package com.yunxi.framework.tracer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * BizTracer 配置类配置属性
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@ConfigurationProperties(prefix = "yunxi.tracer")
@Data
public class TracerProperties {

}
