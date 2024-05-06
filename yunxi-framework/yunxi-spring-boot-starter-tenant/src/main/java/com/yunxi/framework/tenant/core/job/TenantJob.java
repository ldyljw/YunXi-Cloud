package com.yunxi.framework.tenant.core.job;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 多租户 Job 注解
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TenantJob {
}
