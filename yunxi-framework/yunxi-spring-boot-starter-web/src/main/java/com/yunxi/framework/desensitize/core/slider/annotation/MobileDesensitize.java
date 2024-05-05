package com.yunxi.framework.desensitize.core.slider.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.yunxi.framework.desensitize.core.base.annotation.DesensitizeBy;
import com.yunxi.framework.desensitize.core.slider.handler.MobileDesensitizationHandler;

import java.lang.annotation.*;

/**
 * <p>
 * 手机号脱敏注解
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = MobileDesensitizationHandler.class)
public @interface MobileDesensitize {

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 3;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 4;

    /**
     * 替换规则，手机号;比如：13248765917 脱敏之后为 132****5917
     */
    String replacer() default "*";

}
