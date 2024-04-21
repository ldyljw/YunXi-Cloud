package com.yunxi.system.enums.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 短信模板类型枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum SmsTemplateTypeEnum {

    VERIFICATION_CODE(1), // 验证码
    NOTICE(2), // 通知
    PROMOTION(3), // 营销
    ;

    /**
     * 类型
     */
    private final int type;

}
