package com.yunxi.framework.apilog.core.service;

import com.yunxi.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;

/**
 * <p>
 * API 访问日志 Framework Service 接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public interface ApiAccessLogFrameworkService {

    /**
     * 创建 API 访问日志
     *
     * @param reqDTO API 访问日志
     */
    void createApiAccessLog(ApiAccessLogCreateReqDTO reqDTO);

}
