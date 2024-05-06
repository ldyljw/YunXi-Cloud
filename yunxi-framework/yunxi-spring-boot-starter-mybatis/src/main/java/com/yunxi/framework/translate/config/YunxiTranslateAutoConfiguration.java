package com.yunxi.framework.translate.config;

import com.fhs.trans.service.impl.TransService;
import com.yunxi.framework.translate.core.TranslateUtils;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * VO 数据翻译配置类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@AutoConfiguration
public class YunxiTranslateAutoConfiguration {

    @Bean
    @SuppressWarnings({"InstantiationOfUtilityClass", "SpringJavaInjectionPointsAutowiringInspection"})
    public TranslateUtils translateUtils(TransService transService) {
        TranslateUtils.init(transService);
        return new TranslateUtils();
    }

}
