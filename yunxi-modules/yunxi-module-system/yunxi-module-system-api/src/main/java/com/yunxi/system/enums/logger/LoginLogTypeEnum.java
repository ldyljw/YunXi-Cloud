package com.yunxi.system.enums.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 登录日志的类型枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum LoginLogTypeEnum {

    LOGIN_USERNAME(100),// 使用账号登录
    LOGIN_SOCIAL(101),// 使用社交登录
    LOGIN_MOBILE(103),// 使用手机登录
    LOGIN_SMS(104),// 使用短信登录

    LOGOUT_SELF(200),// 自己主动退出
    LOGOUT_DELETE(202),// 强制退出
    ;

    /**
     * 日志类型
     */
    private final Integer type;
}
