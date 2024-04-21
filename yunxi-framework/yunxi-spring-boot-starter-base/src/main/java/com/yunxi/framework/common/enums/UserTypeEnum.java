package com.yunxi.framework.common.enums;

import com.yunxi.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * <p>
 * 全局用户类型枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum implements IntArrayValuable {
    MEMBER(1, "会员"),// 面向 C 端，普通用户
    ADMIN(2, "管理员"),// 面向 B 端，管理后台
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserTypeEnum::getValue).toArray();
    /**
     * 类型
     */
    private final Integer value;
    /**
     * 类型名
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
