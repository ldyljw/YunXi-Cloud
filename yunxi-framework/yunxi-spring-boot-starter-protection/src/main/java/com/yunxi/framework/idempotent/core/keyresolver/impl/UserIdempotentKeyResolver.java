package com.yunxi.framework.idempotent.core.keyresolver.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.yunxi.framework.idempotent.core.annotation.Idempotent;
import com.yunxi.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.yunxi.framework.web.core.util.WebFrameworkUtils;
import org.aspectj.lang.JoinPoint;

/**
 * <p>
 * 用户级别的幂等 Key 解析器，使用方法名 + 方法参数 + userId + userType，组装成一个 Key
 * </p>
 * 为了避免 Key 过长，使用 MD5 进行“压缩”
 *
 * @author lidy
 * @since 2024-05-06
 */
public class UserIdempotentKeyResolver implements IdempotentKeyResolver {

    @Override
    public String resolver(JoinPoint joinPoint, Idempotent idempotent) {
        String methodName = joinPoint.getSignature().toString();
        String argsStr = StrUtil.join(",", joinPoint.getArgs());
        Long userId = WebFrameworkUtils.getLoginUserId();
        Integer userType = WebFrameworkUtils.getLoginUserType();
        return SecureUtil.md5(methodName + argsStr + userId + userType);
    }

}
