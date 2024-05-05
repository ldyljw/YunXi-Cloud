package com.yunxi.framework.apilog.config;

import com.yunxi.framework.apilog.core.filter.ApiAccessLogFilter;
import com.yunxi.framework.apilog.core.interceptor.ApiAccessLogInterceptor;
import com.yunxi.framework.apilog.core.service.ApiAccessLogFrameworkService;
import com.yunxi.framework.apilog.core.service.ApiErrorLogFrameworkService;
import com.yunxi.framework.apilog.core.service.impl.ApiAccessLogFrameworkServiceImpl;
import com.yunxi.framework.apilog.core.service.impl.ApiErrorLogFrameworkServiceImpl;
import com.yunxi.framework.common.enums.WebFilterOrderEnum;
import com.yunxi.framework.web.config.WebProperties;
import com.yunxi.framework.web.config.YunxiWebAutoConfiguration;
import com.yunxi.module.infra.api.logger.ApiAccessLogApi;
import com.yunxi.module.infra.api.logger.ApiErrorLogApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

/**
 * <p>
 * API 接口日志自动配置类
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@AutoConfiguration(after = YunxiWebAutoConfiguration.class)
public class YunxiApiLogAutoConfiguration implements WebMvcConfigurer {

    private static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ApiAccessLogFrameworkService apiAccessLogFrameworkService(ApiAccessLogApi apiAccessLogApi) {
        return new ApiAccessLogFrameworkServiceImpl(apiAccessLogApi);
    }

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ApiErrorLogFrameworkService apiErrorLogFrameworkService(ApiErrorLogApi apiErrorLogApi) {
        return new ApiErrorLogFrameworkServiceImpl(apiErrorLogApi);
    }

    /**
     * 创建 ApiAccessLogFilter Bean，记录 API 请求日志
     */
    @Bean
    @ConditionalOnProperty(prefix = "yunxi.access-log", value = "enable", matchIfMissing = true)
    // 允许使用 yunxi.access-log.enable=false 禁用访问日志
    public FilterRegistrationBean<ApiAccessLogFilter> apiAccessLogFilter(WebProperties webProperties,
                                                                         @Value("${spring.application.name}") String applicationName,
                                                                         ApiAccessLogFrameworkService apiAccessLogFrameworkService) {
        ApiAccessLogFilter filter = new ApiAccessLogFilter(webProperties, applicationName, apiAccessLogFrameworkService);
        return createFilterBean(filter, WebFilterOrderEnum.API_ACCESS_LOG_FILTER);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiAccessLogInterceptor());
    }

}
