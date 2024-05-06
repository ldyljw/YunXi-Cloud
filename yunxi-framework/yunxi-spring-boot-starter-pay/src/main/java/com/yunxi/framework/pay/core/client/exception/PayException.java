package com.yunxi.framework.pay.core.client.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 支付系统异常 Exception
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayException extends RuntimeException {

    public PayException(Throwable cause) {
        super(cause);
    }

}
