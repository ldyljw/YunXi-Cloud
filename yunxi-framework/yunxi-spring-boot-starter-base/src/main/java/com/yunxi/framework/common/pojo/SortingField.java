package com.yunxi.framework.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 排序字段 DTO
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortingField implements Serializable {


    /**
     * 顺序 - 升序
     */
    public static final String ORDER_ASC = "asc";

    /**
     * 顺序 - 降序
     */
    public static final String ORDER_DESC = "desc";

    /**
     * 字段
     */
    private String field;

    /**
     * 顺序
     */
    private String order;


}
