package com.yunxi.system.api.sms;

import com.yunxi.system.enums.constant.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * RPC 服务 - 短信发送
 * </p>
 *
 * @author lidy
 * @since 2024-04-25
 */
@Tag(name = "RPC 服务 - 短信发送")
@FeignClient(name = ApiConstants.NAME)
public interface SmsSendApi {

    String PREFIX = ApiConstants.PREFIX + "/sms/send";

}
