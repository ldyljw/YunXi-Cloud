package com.yunxi.system.api.logger;

import com.yunxi.system.enums.constant.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

import javax.print.attribute.standard.MediaSize;

/**
 * <p>
 * RPC 服务 - 登录日志
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@FeignClient(name = ApiConstants.NAME)
@Tag(name = "RPC 服务 - 登录日志")
public interface LoginLogApi {

    String PREFIX = ApiConstants.PREFIX + "/login-log";

}
