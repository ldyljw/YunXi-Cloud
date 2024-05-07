package com.yunxi.module.system.api.permission;

import com.yunxi.framework.common.pojo.CommonResult;
import com.yunxi.module.system.service.permission.PermissionService;
import com.yunxi.system.api.permission.PermissionApi;
import com.yunxi.system.api.permission.dto.DeptDataPermissionRespDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * <p>
 * 提供 RESTful API 接口，给 Feign 调用
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@RestController
@Validated
public class PermissionApiImpl implements PermissionApi {

    @Resource
    private PermissionService permissionService;

    /**
     * 获得拥有多个角色的用户编号集合
     *
     * @param roleIds 角色 ID 集合
     * @return 用户编号集合
     */
    @Override
    public CommonResult<Set<Long>> getUserRoleIdListByRoleIds(Collection<Long> roleIds) {
        return CommonResult.success(permissionService.getUserRoleIdListByRoleId(roleIds));
    }

    /**
     * 判断用户是否有角色：具有其中一个即可
     *
     * @param userId 用户编号
     * @param roles  角色集合
     * @return 判断结果
     */
    @Override
    public CommonResult<Boolean> hasAnyRoles(Long userId, String... roles) {
        return CommonResult.success(permissionService.hasAnyRoles(userId, roles));
    }

    /**
     * 判断是否有权限，任一一个即可
     *
     * @param userId      用户编号
     * @param permissions 权限
     * @return 判断结果
     */
    @Override
    public CommonResult<Boolean> hasAnyPermissions(Long userId, String... permissions) {
        return CommonResult.success(permissionService.hasAnyPermissions(userId, permissions));
    }

    /**
     * 获得登陆用户的部门数据权限
     *
     * @param userId 用户编号
     * @return 部门数据权限
     */
    @Override
    public CommonResult<DeptDataPermissionRespDTO> getDeptDataPermission(Long userId) {
        return CommonResult.success(permissionService.getDeptDataPermission(userId));
    }
}
