package com.yunxi.framework.lock4j.core;

import com.baomidou.lock.LockFailureStrategy;
import com.yunxi.framework.common.exception.ServiceException;
import com.yunxi.framework.common.exception.enums.GlobalErrorCodeConstants;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * <p>
 * 自定义获取锁失败策略，抛出 {@link ServiceException} 异常
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Slf4j
public class DefaultLockFailureStrategy implements LockFailureStrategy {

    @Override
    public void onLockFailure(String key, Method method, Object[] arguments) {
        log.debug("[onLockFailure][线程:{} 获取锁失败，key:{} 获取失败:{} ]", Thread.currentThread().getName(), key, arguments);
        throw new ServiceException(GlobalErrorCodeConstants.LOCKED);
    }

}
