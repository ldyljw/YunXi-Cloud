package com.yunxi.module.system.service.user.impl;

import com.yunxi.module.system.dal.dataobject.user.AdminUserDO;
import com.yunxi.module.system.dal.mapper.user.AdminUserMapper;
import com.yunxi.module.system.service.user.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户 Service 接口实现类
 * </p>
 *
 * @author lidy
 * @since 2024-05-08
 */
@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper userMapper;

    /**
     * 通过用户 ID 查询用户
     *
     * @param id 用户ID
     * @return 用户对象信息
     */
    @Override
    public AdminUserDO getUser(Long id) {
        return userMapper.selectById(id);
    }
}
