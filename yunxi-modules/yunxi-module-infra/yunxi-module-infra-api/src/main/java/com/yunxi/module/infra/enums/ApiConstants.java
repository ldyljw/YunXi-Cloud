package com.yunxi.module.infra.enums;

import com.yunxi.framework.common.enums.RpcConstants;

/**
 * <p>
 * API 相关的枚举
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
public class ApiConstants {

    /**
     * 服务名
     *
     * 注意，需要保证和 spring.application.name 保持一致
     */
    public static final String NAME = "infra-server";

    public static final String PREFIX = RpcConstants.RPC_API_PREFIX + "/infra";

    public static final String VERSION = "1.0.1";

}
