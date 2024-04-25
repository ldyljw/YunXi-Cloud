package com.yunxi.system.api.permission;

import com.yunxi.system.enums.constant.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * RPC 服务 - 角色
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@Tag(name = "RPC 服务 - 角色")
@FeignClient(name = ApiConstants.NAME)
public interface RoleApi {

    String PREFIX = ApiConstants.PREFIX + "/role";

}
