package com.yunxi.framework.tenant.core.db;

import com.yunxi.framework.mybatis.core.dataobject.BaseDO;

/**
 * <p>
 * 拓展多租户的 BaseDO 基类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public abstract class TenantBaseDO extends BaseDO {

    /**
     * 多租户编号
     */
    private Long tenantId;

}
