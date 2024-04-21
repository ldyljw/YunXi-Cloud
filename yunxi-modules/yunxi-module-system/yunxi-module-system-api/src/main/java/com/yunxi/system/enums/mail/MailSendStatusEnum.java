package com.yunxi.system.enums.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 邮件发送状态枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum MailSendStatusEnum {

    INIT(0), // 初始化
    SUCCESS(10), // 发送成功
    FAILURE(20), // 发送失败
    IGNORE(30), // 忽略，即不发送
    ;

    private final int status;

}
