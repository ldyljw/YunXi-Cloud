package com.yunxi.system.enums.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 菜单类型枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum MenuTypeEnum {

    DIR(1), // 目录
    MENU(2), // 菜单
    BUTTON(3) // 按钮
    ;

    /**
     * 类型
     */
    private final Integer type;

}
