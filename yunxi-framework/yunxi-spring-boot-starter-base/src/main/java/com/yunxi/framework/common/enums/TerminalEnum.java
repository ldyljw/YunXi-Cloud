package com.yunxi.framework.common.enums;

import com.yunxi.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * <p>
 * 终端枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum TerminalEnum implements IntArrayValuable {
    UNKNOWN(0, "未知"),// 目的：在无法解析到 terminal 的时候，用它
    WECHAT_MINI_PROGRAM(10, "微信小程序"),
    WECHAT_WAP(11, "微信公众号"),
    H5(11, "H5 网页"),
    APP(31, "手机 APP"),
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(TerminalEnum::getTerminal).toArray();

    /**
     * 终端
     */
    private final Integer terminal;

    /**
     * 终端名
     */
    private final String name;


    @Override
    public int[] array() {
        return ARRAYS;
    }
}
