package com.yunxi.framework.common.util.monitor;

import org.apache.skywalking.apm.toolkit.trace.TraceContext;

/**
 * <p>
 * 链路追踪工具类
 * 考虑到每个 starter 都需要用到该工具类，所以放到 yunxi-spring-boot-starter-base 模块下的 util 包下
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
public class TracerUtils {

    /**
     * 私有化构造方法
     */
    private TracerUtils() {
    }

    /**
     * 获得链路追踪编号，直接返回 SkyWalking 的 TraceId。
     * 如果不存在的话为空字符串！！！
     *
     * @return 链路追踪编号
     */
    public static String getTraceId() {
        return TraceContext.traceId();
    }

}
