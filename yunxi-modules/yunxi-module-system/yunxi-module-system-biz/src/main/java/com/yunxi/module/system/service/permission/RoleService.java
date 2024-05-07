package com.yunxi.module.system.service.permission;

import com.yunxi.module.system.dal.dataobject.permission.RoleDO;

import java.util.Collection;

/**
 * <p>
 * 角色 Service
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
public interface RoleService {

    /**
     * 判断角色编号数组中，是否有管理员
     *
     * @param ids 角色编号数组
     * @return 是否有管理员
     */
    boolean hasAnySuperAdmin(Collection<Long> ids);

    /**
     * 从缓存中获得角色
     *
     * @param id 角色 ID
     * @return 角色
     */
    RoleDO getRoleFromCache(Long id);
}
