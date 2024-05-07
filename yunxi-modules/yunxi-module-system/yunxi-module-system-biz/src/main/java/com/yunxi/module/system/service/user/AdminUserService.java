package com.yunxi.module.system.service.user;

import com.yunxi.module.system.dal.dataobject.user.AdminUserDO;

/**
 * <p>
 * 后台用户 Service 接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-08
 */
public interface AdminUserService {

    /**
     * 通过用户 ID 查询用户
     *
     * @param id 用户ID
     * @return 用户对象信息
     */
    AdminUserDO getUser(Long id);

}
