package com.yunxi.system.api.logger;

import com.yunxi.framework.common.pojo.CommonResult;
import com.yunxi.framework.common.pojo.PageResult;
import com.yunxi.system.api.logger.dto.OperateLogCreateReqDTO;
import com.yunxi.system.api.logger.dto.OperateLogPageReqDTO;
import com.yunxi.system.api.logger.dto.OperateLogRespDTO;
import com.yunxi.system.enums.constant.ApiConstants;
import feign.QueryMap;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * <p>
 * RPC 服务 - 操作日志
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@FeignClient(name = ApiConstants.NAME)
@Tag(name = "RPC 服务 - 操作日志")
public interface OperateLogApi {

    String PREFIX = ApiConstants.PREFIX + "/operate-log";


    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建操作日志")
    CommonResult<Boolean> createOperateLog(@Valid @RequestBody OperateLogCreateReqDTO createReqDTO);

    @PostMapping(PREFIX + "/page")
    @Operation(summary = "获取指定模块的指定数据的操作日志分页")
    CommonResult<PageResult<OperateLogRespDTO>> getOperateLogPage(@QueryMap OperateLogPageReqDTO pageReqVO);

}
