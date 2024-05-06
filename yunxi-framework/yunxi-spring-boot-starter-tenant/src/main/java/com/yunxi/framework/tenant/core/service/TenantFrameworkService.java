package com.yunxi.framework.tenant.core.service;

import java.util.List;

/**
 * <p>
 * Tenant 框架 Service 接口，定义获取租户信息
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public interface TenantFrameworkService {

    /**
     * 获得所有租户
     *
     * @return 租户编号数组
     */
    List<Long> getTenantIds();

    /**
     * 校验租户是否合法
     *
     * @param id 租户编号
     */
    void validTenant(Long id);

}
