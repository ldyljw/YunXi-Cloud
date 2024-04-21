package com.yunxi.gateway.util;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpHeaders;

import java.util.Objects;

/**
 * <p>
 * 环境工具类
 * 复制 yunxi-spring-boot-starter-env 的 EnvUtils 类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
public class EnvUtils {

    public static final String HOST_NAME_VALUE = "${HOSTNAME}";
    private static final String HEADER_TAG = "tag";

    public static String getTag(HttpHeaders headers) {
        String tag = headers.getFirst(HEADER_TAG);
        // 如果请求的是 "${HOSTNAME}"，则解析成对应的本地主机名
        // 目的：特殊逻辑，解决 IDEA Rest Client 不支持环境变量的读取，所以就服务器来做
        return Objects.equals(tag, HOST_NAME_VALUE) ? getHostName() : tag;
    }

    public static String getTag(ServiceInstance instance) {
        return instance.getMetadata().get(HEADER_TAG);
    }

    public static String getHostName() {
        return StrUtil.blankToDefault(NetUtil.getLocalHostName(), IdUtil.fastSimpleUUID());
    }

}
