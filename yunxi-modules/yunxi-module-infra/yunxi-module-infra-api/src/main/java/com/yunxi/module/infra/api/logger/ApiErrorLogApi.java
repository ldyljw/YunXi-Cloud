package com.yunxi.module.infra.api.logger;

import com.yunxi.module.infra.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

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

}
