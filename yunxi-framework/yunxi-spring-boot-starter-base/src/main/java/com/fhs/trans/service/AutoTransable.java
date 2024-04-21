package com.fhs.trans.service;

import com.fhs.core.trans.vo.VO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 只有实现了这个接口的才能自动编译
 * 为什么要赋值粘贴到 yunxi-spring-boot-starter-base 包下？
 * 因为 AutoTransable 属于 easy-trans-service 下，无法方便的在 yunxi-module-xxx-api 模块下使用
 *
 * </p>
 *
 * @author lidy
 * @since 2024-04-20
 */
public interface AutoTransable<V extends VO> {

    /**
     * 根据 ids 查询数据列表
     * 该方法已过期，请使用 selectByIds
     *
     * @param ids 编号数组
     * @return 数据列表
     */
    default List<V> findByIds(List<? extends Objects> ids) {
        return new ArrayList<>();
    }

    /**
     * 根据 ids 查询
     *
     * @param ids 编号数组
     * @return 数据列表
     */
    default List<V> selectByIds(List<? extends Objects> ids) {
        return this.findByIds(ids);
    }

    /**
     * 获取 db 中的所有数据
     *
     * @return db 中的所有数据
     */
    default List<V> select() {
        return new ArrayList<>();
    }

    /**
     * 根据 ID 获取 VO
     *
     * @param primaryValue ID
     * @return VO
     */
    V selectById(Objects primaryValue);

}
