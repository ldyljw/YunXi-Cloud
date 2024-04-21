package com.yunxi.system.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 性别枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum SexEnum {

    /**
     * 男
     */
    MALE(1),
    /**
     * 女
     */
    FEMALE(2),
    /* 未知 */
    UNKNOWN(3);

    /**
     * 性别
     */
    private final Integer sex;

}
