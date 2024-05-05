package com.yunxi.framework.apilog.core.service.impl;

import com.yunxi.framework.apilog.core.service.ApiAccessLogFrameworkService;
import com.yunxi.module.infra.api.logger.ApiAccessLogApi;
import com.yunxi.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 * API 访问日志 Framework Service 实现类
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
@RequiredArgsConstructor
public class ApiAccessLogFrameworkServiceImpl implements ApiAccessLogFrameworkService {

    private final ApiAccessLogApi apiAccessLogApi;

    @Override
    @Async
    public void createApiAccessLog(ApiAccessLogCreateReqDTO reqDTO) {
        apiAccessLogApi.createApiAccessLog(reqDTO);
    }
}
