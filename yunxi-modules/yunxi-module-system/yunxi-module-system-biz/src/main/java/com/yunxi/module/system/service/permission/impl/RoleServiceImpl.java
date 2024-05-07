package com.yunxi.module.system.service.permission.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.yunxi.framework.common.util.spring.SpringUtils;
import com.yunxi.module.system.dal.dataobject.permission.RoleDO;
import com.yunxi.module.system.dal.mapper.permission.RoleMapper;
import com.yunxi.module.system.dal.redis.RedisKeyConstants;
import com.yunxi.module.system.service.permission.RoleService;
import com.yunxi.system.enums.permission.RoleCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * <p>
 * 角色 Service 实现类
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 判断角色编号数组中，是否有管理员
     *
     * @param ids 角色编号数组
     * @return 是否有管理员
     */
    @Override
    public boolean hasAnySuperAdmin(Collection<Long> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            return false;
        }
        RoleServiceImpl self = getSelf();

        return ids.stream().anyMatch(id -> {
            RoleDO roleDO = self.getRoleFromCache(id);
            return roleDO != null && RoleCodeEnum.isSuperAdmin(roleDO.getCode());
        });
    }

    /**
     * 从缓存中获得角色
     *
     * @param id 角色 ID
     * @return 角色
     */
    @Override
    @Cacheable(value = RedisKeyConstants.ROLE, key = "#id", unless = "#result == null ")
    public RoleDO getRoleFromCache(Long id) {
        return roleMapper.selectById(id);
    }

    /**
     * 获得自身的代理对象，解决 AOP 不生效问题
     *
     * @return 自身的代理对象
     */
    private RoleServiceImpl getSelf() {
        return SpringUtils.getBean(getClass());
    }

}
