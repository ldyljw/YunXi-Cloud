package com.yunxi.framework.common.util.collection;

import cn.hutool.core.collection.CollUtil;

import java.util.Set;

/**
 * <p>
 * Set 工具类
 * </p>
 *
 * @author lidy
 * @since 2024-04-21
 */
public class SetUtils {


    @SafeVarargs
    public static <T> Set<T> asSet(T... objs) {
        return CollUtil.newHashSet(objs);
    }


}
