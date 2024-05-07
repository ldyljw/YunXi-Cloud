package com.yunxi.module.system.dal.mapper.permission;

import com.yunxi.framework.mybatis.core.mapper.BaseMapperX;
import com.yunxi.module.system.dal.dataobject.permission.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 用户-角色关联 mapper
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@Mapper
public interface UserRoleMapper extends BaseMapperX<UserRoleDO> {

    /**
     * 获得拥有多个角色的用户集合
     *
     * @param roleIds 角色集合
     * @return 拥有多个角色的用户集合
     */
    default List<UserRoleDO> selectListByRoleIds(Collection<Long> roleIds) {
        return selectList(UserRoleDO::getRoleId, roleIds);
    }

    /**
     * 获取用户拥有的角色集合
     *
     * @param userId 用户编号
     * @return 角色集合
     */
    default Collection<UserRoleDO> selectListByUserId(Long userId) {
        return selectList(UserRoleDO::getUserId, userId);
    }
}
