package com.yunxi.module.system.dal.mapper.permission;

import com.yunxi.framework.mybatis.core.mapper.BaseMapperX;
import com.yunxi.module.system.dal.dataobject.permission.RoleMenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 角色-菜单关联 mapper 接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@Mapper
public interface RoleMenuMapper extends BaseMapperX<RoleMenuDO> {

    /**
     * 获得拥有该菜单的角色
     *
     * @param menuId 菜单编号
     * @return 角色菜单关联集合
     */
    default List<RoleMenuDO> selectListByMenuId(Long menuId) {
        return selectList(RoleMenuDO::getMenuId, menuId);
    }
}
