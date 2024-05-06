package com.yunxi.framework.security.core;

import cn.hutool.core.map.MapUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yunxi.framework.common.enums.UserTypeEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 登录用户信息
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Data
public class LoginUser {

    public static final String INFO_KEY_NICKNAME = "nickname";

    public static final String INFO_KEY_DEPT_ID = "deptId";

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 用户类型
     * <p>
     * 关联 {@link UserTypeEnum}
     */
    private Integer userType;

    /**
     * 额外的用户信息
     */
    private Map<String, String> info;

    /**
     * 租户编号
     */
    private Long tenantId;

    /**
     * 授权范围
     */
    private List<String> scopes;

    // ========== 上下文 ==========
    /**
     * 上下文字段，不进行持久化
     * <p>
     * 1. 用于基于 LoginUser 维度的临时缓存
     */
    @JsonIgnore
    private Map<String, Object> context;

    public void setContext(String key, Object value) {
        if (context == null) {
            context = new HashMap<>();
        }
        context.put(key, value);
    }

    public <T> T getContext(String key, Class<T> type) {
        return MapUtil.get(context, key, type);
    }

}
