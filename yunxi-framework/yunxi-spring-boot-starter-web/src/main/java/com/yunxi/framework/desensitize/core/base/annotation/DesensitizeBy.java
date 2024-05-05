package com.yunxi.framework.desensitize.core.base.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yunxi.framework.desensitize.core.base.handler.DesensitizationHandler;
import com.yunxi.framework.desensitize.core.base.serializer.StringDesensitizeSerializer;

import java.lang.annotation.*;

/**
 * <p>
 * 顶级脱敏注解，自定义注解需要使用此注解
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside // 此注解是其他所有 Jackson 注解的元注解，打上了次注解的注解表明是 Jackson 注解的一部分
@JsonSerialize(using = StringDesensitizeSerializer.class) // 指定序列化器
public @interface DesensitizeBy {

    /**
     * 脱敏处理器
     */
    @SuppressWarnings("rawtypes")
    Class<? extends DesensitizationHandler> handler();

}
