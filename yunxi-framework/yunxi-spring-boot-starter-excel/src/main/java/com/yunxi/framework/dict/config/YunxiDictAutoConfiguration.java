package com.yunxi.framework.dict.config;

import com.yunxi.framework.dict.core.DictFrameworkUtils;
import com.yunxi.system.api.dict.DictDataApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * 字典自动配置
 * </p>
 *
 * @author lidy
 * @since 2024-04-27
 */
@AutoConfiguration
public class YunxiDictAutoConfiguration {

    @Bean
    @SuppressWarnings({"InstantiationOfUtilityClass"})
    public DictFrameworkUtils dictUtils(DictDataApi dictDataApi) {
        DictFrameworkUtils.init(dictDataApi);
        return new DictFrameworkUtils();
    }
}
