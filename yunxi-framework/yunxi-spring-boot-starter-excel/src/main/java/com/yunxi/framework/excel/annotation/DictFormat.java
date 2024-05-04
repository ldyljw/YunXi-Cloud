package com.yunxi.framework.excel.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 字典格式化
 * </p>
 *
 * @author lidy
 * @since 2024-04-27
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DictFormat {

    /**
     * 字典类型，例如：SysDictTypeConstants、InfDictTypeConstants
     */
    String value();
    

}
