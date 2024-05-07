package com.yunxi.module.system.dal.dataobject.dept;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yunxi.framework.mybatis.core.dataobject.BaseDO;
import com.yunxi.module.system.dal.dataobject.user.AdminUserDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户和岗位关联表 DO
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@TableName("system_user_post")
// 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@KeySequence("system_user_post_seq")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPostDO extends BaseDO {

    /**
     * 自增主键
     */
    @TableId
    private Long id;

    /**
     * 用户 ID
     * <p>
     * 关联 {@link AdminUserDO#getId()}
     */
    private Long userId;

    /**
     * 角色 ID
     * <p>
     * 关联 {@link PostDO#getId()}
     */
    private Long postId;

}
