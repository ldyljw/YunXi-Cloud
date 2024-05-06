package com.yunxi.framework.tenant.core.rpc;

import com.yunxi.framework.tenant.core.context.TenantContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import static com.yunxi.framework.web.core.util.WebFrameworkUtils.HEADER_TENANT_ID;

/**
 * <p>
 * Tenant 的 RequestInterceptor 实现类：Feign 请求时，将 {@link TenantContextHolder} 设置到 header 中，继续透传给被调用的服务
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public class TenantRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Long tenantId = TenantContextHolder.getTenantId();
        if (tenantId != null) {
            requestTemplate.header(HEADER_TENANT_ID, String.valueOf(tenantId));
        }
    }

}
