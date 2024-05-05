package com.yunxi.framework.desensitize.core.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.yunxi.framework.desensitize.core.DesensitizeTest;
import com.yunxi.framework.desensitize.core.base.annotation.DesensitizeBy;
import com.yunxi.framework.desensitize.core.handler.AddressHandler;

import java.lang.annotation.*;

/**
 * <p>
 * 地址
 * </p>
 * 用于 {@link DesensitizeTest} 测试使用
 *
 * @author lidy
 * @since 2024-05-05
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = AddressHandler.class)
public @interface Address {

    String replacer() default "*";

}
