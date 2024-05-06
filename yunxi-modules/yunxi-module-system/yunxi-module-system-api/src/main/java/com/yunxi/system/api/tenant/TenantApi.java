package com.yunxi.system.api.tenant;

import com.yunxi.framework.common.pojo.CommonResult;
import com.yunxi.system.enums.constant.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @GetMapping(PREFIX + "/id-list")
    @Operation(summary = "获得所有租户编号")
    CommonResult<List<Long>> getTenantIdList();

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "校验租户是否合法")
    @Parameter(name = "id", description = "租户编号", required = true, example = "1024")
    CommonResult<Boolean> validTenant(@RequestParam("id") Long id);

}
