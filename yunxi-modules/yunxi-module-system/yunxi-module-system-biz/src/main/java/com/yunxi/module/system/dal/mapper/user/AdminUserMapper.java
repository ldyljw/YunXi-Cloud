package com.yunxi.module.system.dal.mapper.user;

import com.yunxi.framework.mybatis.core.mapper.BaseMapperX;
import com.yunxi.module.system.dal.dataobject.user.AdminUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 mapper 接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-08
 */
@Mapper
public interface AdminUserMapper extends BaseMapperX<AdminUserDO> {
}
