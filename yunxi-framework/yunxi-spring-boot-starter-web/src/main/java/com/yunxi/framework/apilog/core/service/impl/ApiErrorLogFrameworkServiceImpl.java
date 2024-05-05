package com.yunxi.framework.apilog.core.service.impl;

import com.yunxi.framework.apilog.core.service.ApiErrorLogFrameworkService;
import com.yunxi.module.infra.api.logger.ApiErrorLogApi;
import com.yunxi.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 * API 错误日志 Framework Service 实现类
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@RequiredArgsConstructor
public class ApiErrorLogFrameworkServiceImpl implements ApiErrorLogFrameworkService {

    private final ApiErrorLogApi apiErrorLogApi;

    @Override
    @Async
    public void createApiErrorLog(ApiErrorLogCreateReqDTO reqDTO) {
        apiErrorLogApi.createApiErrorLog(reqDTO);
    }
}
