package com.yunxi.framework.ip.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 区域节点，包括国家、省份、城市、地区等信息
 * </p>
 *
 * @author lidy
 * @since 2024-04-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {

    /**
     * 编号 - 全球，即根目录
     */
    public static final Integer ID_GLOBAL = 0;

    /**
     * 编号 - 中国
     */
    public static final Integer ID_CHINA = 1;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 父节点
     */
    private Area parent;

    /**
     * 子节点
     */
    private List<Area> children;


}
