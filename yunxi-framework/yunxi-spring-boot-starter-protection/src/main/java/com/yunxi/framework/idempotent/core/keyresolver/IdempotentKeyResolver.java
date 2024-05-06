package com.yunxi.framework.idempotent.core.keyresolver;

import com.yunxi.framework.idempotent.core.annotation.Idempotent;
import org.aspectj.lang.JoinPoint;

/**
 * <p>
 * 幂等 Key 解析器接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public interface IdempotentKeyResolver {

    /**
     * 解析一个 Key
     *
     * @param idempotent 幂等注解
     * @param joinPoint  AOP 切面
     * @return Key
     */
    String resolver(JoinPoint joinPoint, Idempotent idempotent);

}
