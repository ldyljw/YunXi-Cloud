package com.yunxi.framework.env.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * 环境配置属性
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@ConfigurationProperties(prefix = "yunxi.env")
@Data
public class EnvProperties {

    public static final String TAG_KEY = "yunxi.env.tag";

    /**
     * 环境标签
     */
    private String tag;

}
