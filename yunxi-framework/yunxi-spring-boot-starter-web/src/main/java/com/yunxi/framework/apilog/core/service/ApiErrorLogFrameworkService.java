package com.yunxi.framework.apilog.core.service;

import com.yunxi.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;

/**
 * <p>
 * API 错误日志 Framework Service 接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public interface ApiErrorLogFrameworkService {

    /**
     * 创建 API 错误日志
     *
     * @param reqDTO API 错误日志
     */
    void createApiErrorLog(ApiErrorLogCreateReqDTO reqDTO);

}
