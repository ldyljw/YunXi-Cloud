package com.yunxi.gateway.filter.security;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 登录用户信息
 * 复制 yunxi-spring-boot-starter-security 的 LoginUser 类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@Data
public class LoginUser {

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 用户类型
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

}
