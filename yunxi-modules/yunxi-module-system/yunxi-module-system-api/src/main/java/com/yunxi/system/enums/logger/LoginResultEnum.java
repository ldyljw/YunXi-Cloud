package com.yunxi.system.enums.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 登录结果枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum LoginResultEnum {

    SUCCESS(0), // 成功
    BAD_CREDENTIALS(10), // 账号或密码不正确
    USER_DISABLED(20), // 用户被禁用
    CAPTCHA_NOT_FOUND(30), // 图片验证码不存在
    CAPTCHA_CODE_ERROR(31), // 图片验证码不正确

    ;

    /**
     * 结果
     */
    private final Integer result;

}
