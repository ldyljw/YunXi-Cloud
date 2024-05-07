package com.yunxi.module.system.dal.mapper.permission;

import com.yunxi.framework.mybatis.core.mapper.BaseMapperX;
import com.yunxi.module.system.dal.dataobject.permission.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单 mapper 接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@Mapper
public interface MenuMapper extends BaseMapperX<MenuDO> {
    default List<MenuDO> selectListByPermission(String permission) {
        return selectList(MenuDO::getPermission, permission);
    }
}
