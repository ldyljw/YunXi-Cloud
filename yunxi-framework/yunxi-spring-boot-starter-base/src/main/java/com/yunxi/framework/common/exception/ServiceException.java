package com.yunxi.framework.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 业务逻辑异常类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ServiceException extends RuntimeException {

    /**
     * 业务错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 无参构造方法，避免反序列化问题
     */
    public ServiceException() {
    }

    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
