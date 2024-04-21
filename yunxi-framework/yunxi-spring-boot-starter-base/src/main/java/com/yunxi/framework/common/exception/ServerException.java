package com.yunxi.framework.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 服务器异常类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ServerException extends RuntimeException {

    /**
     * 全局错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 无参构造方法，避免反序列化问题
     */
    public ServerException() {
    }

    public ServerException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServerException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
