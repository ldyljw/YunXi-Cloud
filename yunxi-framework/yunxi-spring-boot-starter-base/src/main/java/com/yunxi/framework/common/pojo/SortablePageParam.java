package com.yunxi.framework.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * <p>
 * 可排序的分页参数
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Schema(defaultValue = "可排序的分页参数")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SortablePageParam extends PageParam {

    @Schema(defaultValue = "排序字段")
    private List<SortingField> sortingFields;

}
