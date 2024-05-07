package com.yunxi.module.system.service.permission.impl;

import com.yunxi.module.system.dal.dataobject.permission.MenuDO;
import com.yunxi.module.system.dal.mapper.permission.MenuMapper;
import com.yunxi.module.system.dal.redis.RedisKeyConstants;
import com.yunxi.module.system.service.permission.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.yunxi.framework.common.util.collection.CollectionUtils.convertList;

/**
 * <p>
 * 菜单 Service 接口实现类
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 获得权限对应的菜单编号数组
     *
     * @param permission 权限标识
     * @return 数组
     */
    @Override
    @Cacheable(value = RedisKeyConstants.PERMISSION_MENU_ID_LIST, key = "#permission")
    public List<Long> getMenuIdListByPermissionFromCache(String permission) {
        List<MenuDO> menus = menuMapper.selectListByPermission(permission);
        return convertList(menus, MenuDO::getId);
    }

}
