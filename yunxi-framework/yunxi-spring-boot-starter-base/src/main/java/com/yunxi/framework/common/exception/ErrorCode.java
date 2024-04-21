package com.yunxi.framework.common.exception;

import com.yunxi.framework.common.exception.enums.GlobalErrorCodeConstants;
import lombok.Data;

/**
 * <p>
 * 错误码枚举类
 * 全局错误码，占用 [0, 999], 参见 {@link GlobalErrorCodeConstants}
 * 业务异常错误码，占用 [1 000 000 000, +∞)，参见 {@link ServiceErrorCodeRange}
 *
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Data
public class ErrorCode {

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

}
