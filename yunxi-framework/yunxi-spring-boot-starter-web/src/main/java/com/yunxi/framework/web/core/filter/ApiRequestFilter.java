package com.yunxi.framework.web.core.filter;

import cn.hutool.core.util.StrUtil;
import com.yunxi.framework.web.config.WebProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 过滤 /admin-api、/app-api 等 API 请求的过滤器
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@RequiredArgsConstructor
public abstract class ApiRequestFilter extends OncePerRequestFilter {

    protected final WebProperties webProperties;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // 只过滤 API 请求的地址
        return StrUtil.startWithAny(request.getRequestURI(),
                webProperties.getAdminApi().getPrefix(), webProperties.getAppApi().getPrefix());
    }
}
