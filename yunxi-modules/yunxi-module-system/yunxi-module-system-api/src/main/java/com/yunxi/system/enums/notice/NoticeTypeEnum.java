package com.yunxi.system.enums.notice;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 通知类型
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Getter
@AllArgsConstructor
public enum NoticeTypeEnum {

    NOTICE(1),// 通知
    ANNOUNCEMENT(2),// 公告
    ;

    /**
     * 类型
     */
    private final Integer type;

}
