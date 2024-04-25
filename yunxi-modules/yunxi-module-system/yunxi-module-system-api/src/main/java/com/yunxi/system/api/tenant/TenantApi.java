package com.yunxi.system.api.tenant;

import com.yunxi.system.enums.constant.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * RPC 服务 - 多租户
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@Tag(name = "RPC 服务 - 多租户")
@FeignClient(name = ApiConstants.NAME)
public interface TenantApi {

    String PREFIX = ApiConstants.PREFIX + "/tenant";

}
