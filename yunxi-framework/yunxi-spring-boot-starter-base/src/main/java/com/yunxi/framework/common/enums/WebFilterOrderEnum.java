package com.yunxi.framework.common.enums;

/**
 * <p>
 * Web 过滤器顺序的枚举类，保证过滤器符合我们的预期
 * 考虑到每个 starter 都需要用到该枚举类，所以放到 yunxi-spring-boot-starter-base 模块下的 enum 包下
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
public interface WebFilterOrderEnum {

    int CORS_FILTER = Integer.MIN_VALUE;

    int TRACE_FILTER = CORS_FILTER + 1;

    int ENV_TAG_FILTER = TRACE_FILTER + 1;

    int REQUEST_BODY_CACHE_FILTER = Integer.MIN_VALUE + 500;

    // OrderedRequestContextFilter 默认为 -105，用于国际化上下文等
    int TENANT_CONTEXT_FILTER = -104;// 需要保证在 ApiAccessLogFilter 前面

    int API_ACCESS_LOG_FILTER = -103;// 需要保证在 RequestBodyCacheFilter 后面

    int XSS_FILTER = -102;// 需要保证在 RequestBodyCacheFilter 后面

    // Spring Security Filter 默认为 -100，可参考 org.springframework.boot.autoconfigure.security.SecurityProperties 配置属性类
    int TENANT_SECURITY_FILTER = -99;// 需要保证在 Spring Security 过滤器后面

    int FLOWABLE_FILTER = -98;// 需要保证在 Spring Security 后面

    int DEMO_FILTER = Integer.MAX_VALUE;

}
