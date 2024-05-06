package com.yunxi.framework.lock4j.core;

/**
 * <p>
 * Lock4j Redis Key 枚举类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public interface Lock4jRedisKeyConstants {

    /**
     * 分布式锁
     * <p>
     * KEY 格式：lock4j:%s // 参数来自 DefaultLockKeyBuilder 类
     * VALUE 数据格式：HASH // RLock.class：Redisson 的 Lock 锁，使用 Hash 数据结构
     * 过期时间：不固定
     */
    String LOCK4J = "lock4j:%s";

}
