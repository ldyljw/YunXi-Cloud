package com.yunxi.framework.banner.config;

import com.yunxi.framework.banner.core.BannerApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * Banner 自动配置类
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@AutoConfiguration
public class YunxiBannerAutoConfiguration {

    @Bean
    public BannerApplicationRunner bannerApplicationRunner() {
        return new BannerApplicationRunner();
    }

}
