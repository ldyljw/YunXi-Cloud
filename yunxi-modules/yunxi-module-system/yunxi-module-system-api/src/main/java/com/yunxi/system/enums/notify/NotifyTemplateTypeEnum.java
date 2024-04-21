package com.yunxi.system.enums.notify;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 通知模板类型枚举
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum NotifyTemplateTypeEnum {

    /**
     * 系统消息
     */
    SYSTEM_MESSAGE(2),
    /**
     * 通知消息
     */
    NOTIFICATION_MESSAGE(1);

    private final Integer type;

}
