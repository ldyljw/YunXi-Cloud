package com.yunxi.framework.excel.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 给 Excel 列添加下拉选择数据
 * </p>
 *
 * @author lidy
 * @since 2024-04-27
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExcelColumnSelect {

    /**
     * 字典类型
     */
    String dictType() default "";

    /**
     * 获取下拉数据源的方法名称
     */
    String functionName() default "";

}
