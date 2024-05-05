package com.yunxi.module.infra.api.logger;

import com.yunxi.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import com.yunxi.module.infra.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * <p>
 * RPC 服务 - API 异常日志
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@Tag(name = "RPC 服务 - API 异常日志")
@FeignClient(name = ApiConstants.NAME)
public interface ApiErrorLogApi {

    String PREFIX = ApiConstants.PREFIX + "/api-error-log";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建 API 异常日志")
    void createApiErrorLog(@Valid @RequestBody ApiErrorLogCreateReqDTO reqDTO);
}
