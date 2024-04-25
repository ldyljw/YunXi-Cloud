package com.yunxi.system.api.dept;

import com.yunxi.system.enums.constant.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * RPC 服务 - 部门
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
@FeignClient(name = ApiConstants.NAME)
@Tag(name = "RPC 服务 - 部门")
public interface DeptApi {

    String PREFIX = ApiConstants.PREFIX + "/dept";


}
