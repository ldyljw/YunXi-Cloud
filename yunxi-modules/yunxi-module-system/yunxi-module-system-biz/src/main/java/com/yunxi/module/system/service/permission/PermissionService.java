package com.yunxi.module.system.service.permission;

import com.yunxi.system.api.permission.dto.DeptDataPermissionRespDTO;

import java.util.Collection;
import java.util.Set;

/**
 * <p>
 * 权限 Service 接口
 * </p>
 * 提供用户-角色、角色-菜单、角色-部门的关联权限处理
 *
 * @author lidy
 * @since 2024-05-07
 */
public interface PermissionService {

    /***
     * 获得拥有多个角色的用户编号集合
     * @param roleIds 角色编号集合
     * @return 用户编号集合
     */
    Set<Long> getUserRoleIdListByRoleId(Collection<Long> roleIds);

    /**
     * 判断用户是否有角色：具有其中一个即可
     *
     * @param userId 用户编号
     * @param roles  角色集合
     * @return 判断结果
     */
    boolean hasAnyRoles(Long userId, String... roles);

    /**
     * 获得用户拥有的角色编号集合，从缓存中获取
     *
     * @param userId 用户编号
     * @return 角色编号集合
     */
    Set<Long> getUserRoleIdListByUserIdFromCache(Long userId);

    /**
     * 获得用户拥有的角色编号集合
     *
     * @param userId 用户编号
     * @return 角色编号集合
     */
    Set<Long> getUserRoleIdListByUserId(Long userId);

    /**
     * 判断是否有权限，任一一个即可
     *
     * @param userId      用户编号
     * @param permissions 权限
     * @return 判断结果
     */
    boolean hasAnyPermissions(Long userId, String... permissions);

    /**
     * 获得拥有指定菜单的角色编号数组，从缓存中获取
     *
     * @param menuId 菜单编号
     * @return 角色编号数组
     */
    Set<Long> getMenuRoleIdListByMenuIdFromCache(Long menuId);

    /**
     * 获得登陆用户的部门数据权限
     *
     * @param userId 用户编号
     * @return 部门数据权限
     */
    DeptDataPermissionRespDTO getDeptDataPermission(Long userId);
}
