package com.yunxi.module.system.service.permission.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.Sets;
import com.yunxi.framework.common.util.collection.CollectionUtils;
import com.yunxi.framework.common.util.json.JsonUtils;
import com.yunxi.framework.common.util.spring.SpringUtils;
import com.yunxi.framework.datapermission.core.annotation.DataPermission;
import com.yunxi.module.system.dal.dataobject.permission.RoleDO;
import com.yunxi.module.system.dal.dataobject.permission.RoleMenuDO;
import com.yunxi.module.system.dal.dataobject.permission.UserRoleDO;
import com.yunxi.module.system.dal.mapper.permission.RoleMenuMapper;
import com.yunxi.module.system.dal.mapper.permission.UserRoleMapper;
import com.yunxi.module.system.dal.redis.RedisKeyConstants;
import com.yunxi.module.system.service.dept.DeptService;
import com.yunxi.module.system.service.permission.MenuService;
import com.yunxi.module.system.service.permission.PermissionService;
import com.yunxi.module.system.service.permission.RoleService;
import com.yunxi.module.system.service.user.AdminUserService;
import com.yunxi.system.api.permission.dto.DeptDataPermissionRespDTO;
import com.yunxi.system.enums.permission.DataScopeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.yunxi.framework.common.util.collection.CollectionUtils.convertSet;

/**
 * <p>
 * 权限 Service 实现类
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private MenuService menuService;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private RoleService roleService;

    @Resource
    private AdminUserService userService;

    @Resource
    private DeptService deptService;

    /***
     * 获得拥有多个角色的用户编号集合
     * @param roleIds 角色编号集合
     * @return 用户编号集合
     */
    @Override
    public Set<Long> getUserRoleIdListByRoleId(Collection<Long> roleIds) {
        return convertSet(userRoleMapper.selectListByRoleIds(roleIds), UserRoleDO::getUserId);
    }

    /**
     * 判断用户是否有角色：具有其中一个即可
     *
     * @param userId 用户编号
     * @param roles  角色集合
     * @return 判断结果
     */
    @Override
    public boolean hasAnyRoles(Long userId, String... roles) {
        // 如果角色为空，说明已经有权限
        if (ArrayUtil.isEmpty(roles)) {
            return true;
        }

        // 获得当前登录的角色。如果为空，说明没有权限
        List<RoleDO> roleList = getEnableUserRoleListByUserIdFromCache(userId);
        if (CollUtil.isEmpty(roleList)) {
            return false;
        }

        // 判断是否有角色
        Set<String> userRoles = convertSet(roleList, RoleDO::getCode);

        return CollUtil.containsAny(userRoles, Sets.newHashSet(roles));
    }

    /**
     * 获得用户拥有的角色编号集合，从缓存中获取
     *
     * @param userId 用户编号
     * @return 角色编号集合
     */
    @Override
    @Cacheable(value = RedisKeyConstants.USER_ROLE_ID_LIST, key = "#userId")
    public Set<Long> getUserRoleIdListByUserIdFromCache(Long userId) {
        return getUserRoleIdListByUserId(userId);
    }

    /**
     * 获得用户拥有的角色编号集合
     *
     * @param userId 用户编号
     * @return 角色编号集合
     */
    @Override
    public Set<Long> getUserRoleIdListByUserId(Long userId) {
        return convertSet(userRoleMapper.selectListByUserId(userId), UserRoleDO::getRoleId);
    }

    /**
     * 判断是否有权限，任一一个即可
     *
     * @param userId      用户编号
     * @param permissions 权限
     * @return 判断结果
     */
    @Override
    public boolean hasAnyPermissions(Long userId, String... permissions) {
        // 如果为空，说明已经有权限
        if (ArrayUtil.isEmpty(permissions)) {
            return true;
        }

        // 获得当前登录的角色。如果为空，说明没有权限
        List<RoleDO> roles = getEnableUserRoleListByUserIdFromCache(userId);
        if (CollUtil.isEmpty(roles)) {
            return false;
        }

        // 情况一：遍历判断每个权限，如果有一个满足，说明有权限
        for (String permission : permissions) {
            if (hasAnyPermission(roles, permission)) {
                return true;
            }
        }

        // 情况二：如果是超级管理员，也说明有权限
        return roleService.hasAnySuperAdmin(convertSet(roles, RoleDO::getId));
    }

    /**
     * 获得拥有指定菜单的角色编号数组，从缓存中获取
     *
     * @param menuId 菜单编号
     * @return 角色编号数组
     */
    @Override
    public Set<Long> getMenuRoleIdListByMenuIdFromCache(Long menuId) {
        return convertSet(roleMenuMapper.selectListByMenuId(menuId), RoleMenuDO::getRoleId);
    }

    /**
     * 获得登陆用户的部门数据权限
     *
     * @param userId 用户编号
     * @return 部门数据权限
     */
    @Override
    @DataPermission(enable = false) // 关闭数据权限，不然就会出现地柜获取数据权限的问题
    public DeptDataPermissionRespDTO getDeptDataPermission(Long userId) {
        // 获得用户的角色
        List<RoleDO> roles = getEnableUserRoleListByUserIdFromCache(userId);

        // 如果角色为空，则只能查看自己
        DeptDataPermissionRespDTO result = new DeptDataPermissionRespDTO();
        if (CollUtil.isEmpty(roles)) {
            result.setSelf(true);
            return result;
        }

        // 获得用户的部门编号的缓存，通过 Guava 的 Suppliers 惰性请求，即有且仅有一次发起 DB 端的查询
        Supplier<Long> userDeptId = Suppliers.memoize(() -> userService.getUser(userId).getDeptId());
        // 遍历每个角色，计算
        for (RoleDO role : roles) {
            // 为空时，跳过
            if (role.getDataScope() == null) {
                continue;
            }

            // 情况一：ALL
            if (Objects.equals(role.getDataScope(), DataScopeEnum.ALL.getScope())) {
                result.setAll(true);
                continue;
            }

            // 情况二：DEPT_CUSTOM
            if (Objects.equals(role.getDataScope(), DataScopeEnum.DEPT_CUSTOM.getScope())) {
                CollUtil.addAll(result.getDeptIds(), role.getDataScopeDeptIds());
                // 自定义可见部门时，保证可以看到自己所在的部门，否则，一些场景下可能会有问题。
                // 例如说，登录时，基于 t_user 的 username 查询可能会被 dept_id 过滤掉
                CollUtil.addAll(result.getDeptIds(), userDeptId.get());
                continue;
            }

            // 情况三：DEPT_ONLY
            if (Objects.equals(role.getDataScope(), DataScopeEnum.DEPT_ONLY.getScope())) {
                CollectionUtils.addIfNotNull(result.getDeptIds(), userDeptId.get());
                continue;
            }

            // 情况四：DEPT_DEPT_AND_CHILD
            if (Objects.equals(role.getDataScope(), DataScopeEnum.DEPT_AND_CHILD.getScope())) {
                CollUtil.addAll(result.getDeptIds(), deptService.getChildDeptIdListFromCache(userDeptId.get()));
                // 添加本身部门编号
                CollUtil.addAll(result.getDeptIds(), userDeptId.get());
                continue;
            }

            // 情况五：SELF
            if (Objects.equals(role.getDataScope(), DataScopeEnum.SELF.getScope())) {
                result.setSelf(true);
                continue;
            }
            // 未知情况，打印错误日志即可
            log.error("[getDeptDataPermission][LoginUser({}) role({}) 无法处理]", userId, JsonUtils.toJsonString(result));
        }

        return result;
    }

    /**
     * 判断指定角色是否拥有该 permission 权限
     *
     * @param roles      指定角色数组
     * @param permission 权限标识
     * @return 判断结果
     */
    private boolean hasAnyPermission(List<RoleDO> roles, String permission) {
        List<Long> menuIds = menuService.getMenuIdListByPermissionFromCache(permission);
        // 采用严格模式，如果权限找不到对应的 Menu 的话，也认为没有权限
        if (CollUtil.isEmpty(menuIds)) {
            return false;
        }

        // 判断是否有权限
        Set<Long> roleIds = convertSet(roles, RoleDO::getId);
        for (Long menuId : menuIds) {
            // 获得拥有该菜单的角色编号集合
            Set<Long> menuRoleIds = getSelf().getMenuRoleIdListByMenuIdFromCache(menuId);
            // 如果有交集，说明有权限
            if (CollUtil.containsAny(menuRoleIds, roleIds)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获得用户拥有的角色，并且这些角色是开启状态
     *
     * @param userId 用户编号
     * @return 用户拥有的角色
     */
    private List<RoleDO> getEnableUserRoleListByUserIdFromCache(Long userId) {
        // 获得用户拥有的角色编号
        Set<Long> roleIds = getSelf().getUserRoleIdListByUserIdFromCache(userId);

        return null;
    }

    /**
     * 获得自身的代理对象，解决 AOP 生效问题
     *
     * @return 自己的代理对象
     */
    private PermissionServiceImpl getSelf() {
        return SpringUtils.getBean(getClass());
    }

}
