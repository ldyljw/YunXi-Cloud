package com.yunxi.framework.dict.config;

import com.yunxi.system.api.dict.DictDataApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * 字典用到 Feign 远程调用的配置项
 * </p>
 *
 * @author lidy
 * @since 2024-04-27
 */
@AutoConfiguration
@EnableFeignClients(clients = DictDataApi.class) // 主要是引入相关的 API 服务
public class YunxiDictRpcAutoconfiguration {
}
