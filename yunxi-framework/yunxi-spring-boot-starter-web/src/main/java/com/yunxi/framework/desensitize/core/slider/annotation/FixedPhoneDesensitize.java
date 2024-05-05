package com.yunxi.framework.desensitize.core.slider.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.yunxi.framework.desensitize.core.base.annotation.DesensitizeBy;
import com.yunxi.framework.desensitize.core.slider.handler.FixedPhoneDesensitizationHandler;

import java.lang.annotation.*;

/**
 * <p>
 * 固定电话脱敏注解
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = FixedPhoneDesensitizationHandler.class)
public @interface FixedPhoneDesensitize {

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 4;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 2;

    /**
     * 替换规则，固定电话;比如：01086551122 脱敏之后为 0108*****22
     */
    String replacer() default "*";

}
