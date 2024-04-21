package com.yunxi.system.enums.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 短信接收状态枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum SmsReceiveStatusEnum {

    INIT(0), // 初始化
    SUCCESS(10), // 接收成功
    FAILURE(20), // 接收失败
    ;

    private final int status;

}
