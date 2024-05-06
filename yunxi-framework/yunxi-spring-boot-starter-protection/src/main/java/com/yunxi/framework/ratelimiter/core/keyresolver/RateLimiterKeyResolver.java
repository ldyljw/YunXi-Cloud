package com.yunxi.framework.ratelimiter.core.keyresolver;

import com.yunxi.framework.ratelimiter.core.annotation.RateLimiter;
import org.aspectj.lang.JoinPoint;

/**
 * <p>
 * 限流 Key 解析器接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public interface RateLimiterKeyResolver {

    /**
     * 解析一个 Key
     *
     * @param rateLimiter 限流注解
     * @param joinPoint   AOP 切面
     * @return Key
     */
    String resolver(JoinPoint joinPoint, RateLimiter rateLimiter);

}
