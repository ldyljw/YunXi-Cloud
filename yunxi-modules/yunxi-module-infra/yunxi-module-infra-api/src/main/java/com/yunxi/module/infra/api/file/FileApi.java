package com.yunxi.module.infra.api.file;

import com.yunxi.module.infra.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * RPC 服务 - 文件
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@Tag(name = "RPC 服务 - 文件")
@FeignClient(name = ApiConstants.NAME)
public interface FileApi {


    String PREFIX = ApiConstants.PREFIX + "/file";

}
