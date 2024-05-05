package com.yunxi.module.infra.api.logger;

import com.yunxi.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import com.yunxi.module.infra.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * <p>
 * RPC 服务 - API 访问日志
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@Tag(name = "RPC 服务 - API 访问日志")
@FeignClient(name = ApiConstants.NAME)
public interface ApiAccessLogApi {

    String PREFIX = ApiConstants.PREFIX + "/api-access-log";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建 API 访问日志")
    void createApiAccessLog(@Valid @RequestBody ApiAccessLogCreateReqDTO reqDTO);

}
