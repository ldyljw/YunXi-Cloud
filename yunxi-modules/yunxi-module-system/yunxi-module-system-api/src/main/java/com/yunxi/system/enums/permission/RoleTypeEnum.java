package com.yunxi.system.enums.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 角色类型枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum RoleTypeEnum {

    /**
     * 内置角色
     */
    SYSTEM(1),
    /**
     * 自定义角色
     */
    CUSTOM(2);

    private final Integer type;

}
