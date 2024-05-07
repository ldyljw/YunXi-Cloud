package com.yunxi.module.system.service.permission;

import java.util.List;

/**
 * <p>
 * 菜单 Service 接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
public interface MenuService {

    /**
     * 获得权限对应的菜单编号数组
     *
     * @param permission 权限标识
     * @return 数组
     */
    List<Long> getMenuIdListByPermissionFromCache(String permission);

}
