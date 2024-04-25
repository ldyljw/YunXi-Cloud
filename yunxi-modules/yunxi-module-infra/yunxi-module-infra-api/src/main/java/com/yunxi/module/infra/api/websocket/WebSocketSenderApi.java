package com.yunxi.module.infra.api.websocket;

import com.yunxi.module.infra.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * RPC 服务 - WebSocket 发送器的
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@Tag(name = "RPC 服务 - WebSocket 发送器的")
@FeignClient(name = ApiConstants.NAME)
public interface WebSocketSenderApi {

    String PREFIX = ApiConstants.PREFIX + "/websocket";

}
