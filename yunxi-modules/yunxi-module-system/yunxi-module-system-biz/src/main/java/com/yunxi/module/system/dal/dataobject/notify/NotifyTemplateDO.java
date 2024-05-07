package com.yunxi.module.system.dal.dataobject.notify;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.yunxi.framework.common.enums.CommonStatusEnum;
import com.yunxi.framework.mybatis.core.dataobject.BaseDO;
import lombok.*;

import java.util.List;

/**
 * <p>
 * 站内信模板 DO
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@TableName(value = "system_notify_template", autoResultMap = true)
@KeySequence("system_notify_template_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotifyTemplateDO extends BaseDO {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 模版名称
     */
    private String name;

    /**
     * 模版编码
     */
    private String code;

    /**
     * 模版类型
     * <p>
     * 对应 system_notify_template_type 字典
     */
    private Integer type;

    /**
     * 发送人名称
     */
    private String nickname;

    /**
     * 模版内容
     */
    private String content;

    /**
     * 参数数组
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> params;

    /**
     * 状态
     * <p>
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

}
