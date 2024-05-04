package com.yunxi.framework.excel.function;

import java.util.List;

/**
 * <p>
 * Excel 列表下拉数据源获取接口
 * </p>
 *
 * @author lidy
 * @since 2024-04-27
 */
public interface ExcelColumnSelectFunction {

    /**
     * 获得方法名称
     */
    String getName();

    /**
     * 获得列下拉数据源
     */
    List<String> getOptions();
}
