package com.yunxi.system.api.social;

import com.yunxi.system.enums.constant.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * RPC 服务 - 社交应用
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@Tag(name = "RPC 服务 - 社交应用")
@FeignClient(name = ApiConstants.NAME)
public interface SocialClientApi {

    String PREFIX = ApiConstants.PREFIX + "/social-client";

}
