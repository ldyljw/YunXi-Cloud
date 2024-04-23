package com.yunxi.system.api.user;

import com.fhs.trans.service.AutoTransable;
import com.yunxi.system.api.user.dto.AdminUserRespDTO;
import com.yunxi.system.enums.constant.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * RPC 服务 - 管理员用户远程调用
 * </p>
 *
 * @author lidy
 * @since 2024-04-23
 */
@FeignClient(name = ApiConstants.NAME)// TODO ：fallbackFactory =
@Tag(name = "RPC 服务 - 管理员用户远程调用")
//@AutoTrans(namespace = PREFIX, fields = {"nickname"}) // TODO ：需要 easy-trans 做个 bugfix
public interface AdminUserApi extends AutoTransable<AdminUserRespDTO> {

}
