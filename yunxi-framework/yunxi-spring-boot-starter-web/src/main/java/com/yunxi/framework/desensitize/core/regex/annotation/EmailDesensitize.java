package com.yunxi.framework.desensitize.core.regex.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.yunxi.framework.desensitize.core.base.annotation.DesensitizeBy;
import com.yunxi.framework.desensitize.core.regex.handler.EmailDesensitizationHandler;

import java.lang.annotation.*;

/**
 * <p>
 * 邮箱脱敏注解
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = EmailDesensitizationHandler.class)
public @interface EmailDesensitize {

    /**
     * 匹配的正则表达式
     */
    String regex() default "(^.)[^@]*(@.*$)";

    /**
     * 替换规则，邮箱;
     * <p>
     * 比如：example@gmail.com 脱敏之后为 e****@gmail.com
     */
    String replacer() default "$1****$2";

}
