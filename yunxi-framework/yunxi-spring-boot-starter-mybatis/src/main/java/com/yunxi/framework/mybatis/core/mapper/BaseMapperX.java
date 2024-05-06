package com.yunxi.framework.mybatis.core.mapper;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.interfaces.MPJBaseJoin;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.yunxi.framework.common.pojo.PageParam;
import com.yunxi.framework.common.pojo.PageResult;
import com.yunxi.framework.common.pojo.SortablePageParam;
import com.yunxi.framework.common.pojo.SortingField;
import com.yunxi.framework.mybatis.core.util.MyBatisUtils;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 在 MyBatis Plus 的 BaseMapper 的基础上拓展，提供更多的能力
 * </p>
 * 1. {@link BaseMapper} 为 MyBatis Plus 的基础接口，提供基础的 CRUD 能力
 * 2. {@link MPJBaseMapper} 为 MyBatis Plus Join 的基础接口，提供连表 Join 能力
 *
 * @author lidy
 * @since 2024-05-06
 */
public interface BaseMapperX<T> extends MPJBaseMapper<T> {

    /**
     * 分页查询
     *
     * @param pageParam    分页参数
     * @param queryWrapper 查询条件
     * @return 查询结果
     */
    default PageResult<T> selectPage(SortablePageParam pageParam, @Param("ew") Wrapper<T> queryWrapper) {
        return selectPage(pageParam, pageParam.getSortingFields(), queryWrapper);
    }

    /**
     * 分页查询
     *
     * @param pageParam    分页参数
     * @param queryWrapper 查询条件
     * @return 查询结果
     */
    default PageResult<T> selectPage(PageParam pageParam, @Param("ew") Wrapper<T> queryWrapper) {
        return selectPage(pageParam, null, queryWrapper);
    }

    /**
     * 分页查询
     *
     * @param pageParam     分页参数
     * @param sortingFields 排序字段
     * @param queryWrapper  查询条件
     * @return 查询结果
     */
    default PageResult<T> selectPage(PageParam pageParam, Collection<SortingField> sortingFields, @Param("ew") Wrapper<T> queryWrapper) {
        // 特殊：不分页，直接查询全部
        if (PageParam.PAGE_SIZE_NONE.equals(pageParam.getPageSize())) {
            List<T> list = selectList(queryWrapper);
            return new PageResult<>(list, (long) list.size());
        }

        // MyBatis Plus 查询
        IPage<T> mpPage = MyBatisUtils.buildPage(pageParam, sortingFields);
        selectPage(mpPage, queryWrapper);
        // 转换返回
        return new PageResult<>(mpPage.getRecords(), mpPage.getTotal());
    }

    /**
     * 分页连接查询
     *
     * @param pageParam     分页参数
     * @param clazz         连接对象
     * @param lambdaWrapper 查询条件
     * @param <D>           泛型
     * @return 结果
     */
    default <D> PageResult<D> selectJoinPage(PageParam pageParam, Class<D> clazz, MPJLambdaWrapper<T> lambdaWrapper) {
        // 特殊：不分页，直接查询全部
        if (PageParam.PAGE_SIZE_NONE.equals(pageParam.getPageNo())) {
            List<D> list = selectJoinList(clazz, lambdaWrapper);
            return new PageResult<>(list, (long) list.size());
        }

        // MyBatis Plus Join 查询
        IPage<D> mpPage = MyBatisUtils.buildPage(pageParam);
        mpPage = selectJoinPage(mpPage, clazz, lambdaWrapper);
        // 转换返回
        return new PageResult<>(mpPage.getRecords(), mpPage.getTotal());
    }

    /**
     * 分页连接查询
     *
     * @param pageParam        分页参数
     * @param resultTypeClass  连接对象
     * @param joinQueryWrapper 查询条件
     * @param <DTO>            泛型
     * @return 结果
     */
    default <DTO> PageResult<DTO> selectJoinPage(PageParam pageParam, Class<DTO> resultTypeClass, MPJBaseJoin<T> joinQueryWrapper) {
        IPage<DTO> mpPage = MyBatisUtils.buildPage(pageParam);
        selectJoinPage(mpPage, resultTypeClass, joinQueryWrapper);
        // 转换返回
        return new PageResult<>(mpPage.getRecords(), mpPage.getTotal());
    }

    /**
     * 查询一条记录
     *
     * @param field 字段名
     * @param value 字段值
     * @return 结果
     */
    default T selectOne(String field, Object value) {
        return selectOne(new QueryWrapper<T>().eq(field, value));
    }

    /**
     * 查询一条记录
     *
     * @param field 字段名
     * @param value 字段值
     * @return 结果
     */
    default T selectOne(SFunction<T, ?> field, Object value) {
        return selectOne(new LambdaQueryWrapper<T>().eq(field, value));
    }

    /**
     * 查询一条记录
     *
     * @param field1 字段名1
     * @param value1 字段值1
     * @param field2 字段名2
     * @param value2 字段值2
     * @return 结果
     */
    default T selectOne(String field1, Object value1, String field2, Object value2) {
        return selectOne(new QueryWrapper<T>().eq(field1, value1).eq(field2, value2));
    }

    /**
     * 查询一条记录
     *
     * @param field1 字段名1
     * @param value1 字段值1
     * @param field2 字段名2
     * @param value2 字段值2
     * @return 结果
     */
    default T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2) {
        return selectOne(new LambdaQueryWrapper<T>().eq(field1, value1).eq(field2, value2));
    }

    /**
     * 查询一条记录
     *
     * @param field1 字段名1
     * @param value1 字段值1
     * @param field2 字段名2
     * @param value2 字段值2
     * @param field3 字段名3
     * @param value3 字段值3
     * @return 结果
     */
    default T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2, SFunction<T, ?> field3, Object value3) {
        return selectOne(new LambdaQueryWrapper<T>().eq(field1, value1).eq(field2, value2).eq(field3, value3));
    }

    /**
     * 查询数量
     *
     * @return 结果
     */
    default Long selectCount() {
        return selectCount(new QueryWrapper<>());
    }

    /**
     * 查询数量
     *
     * @param field 字段名
     * @param value 字段值
     * @return 结果
     */
    default Long selectCount(String field, Object value) {
        return selectCount(new QueryWrapper<T>().eq(field, value));
    }

    /**
     * 查询数量
     *
     * @param field 字段名
     * @param value 字段值
     * @return 结果
     */
    default Long selectCount(SFunction<T, ?> field, Object value) {
        return selectCount(new LambdaQueryWrapper<T>().eq(field, value));
    }

    /**
     * 查询列表所有
     *
     * @return 结果
     */
    default List<T> selectList() {
        return selectList(new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @param field 字段名
     * @param value 字段值
     * @return 结果
     */
    default List<T> selectList(String field, Object value) {
        return selectList(new QueryWrapper<T>().eq(field, value));
    }

    /**
     * 查询所有
     *
     * @param field 字段名
     * @param value 字段值
     * @return 结果
     */
    default List<T> selectList(SFunction<T, ?> field, Object value) {
        return selectList(new LambdaQueryWrapper<T>().eq(field, value));
    }

    /**
     * 查询所有
     *
     * @param field  字段名
     * @param values 字段值集合
     * @return 结果
     */
    default List<T> selectList(String field, Collection<?> values) {
        if (CollUtil.isEmpty(values)) {
            return CollUtil.newArrayList();
        }
        return selectList(new QueryWrapper<T>().in(field, values));
    }

    /**
     * 查询所有
     *
     * @param field  字段名
     * @param values 字段值集合
     * @return 结果
     */
    default List<T> selectList(SFunction<T, ?> field, Collection<?> values) {
        if (CollUtil.isEmpty(values)) {
            return CollUtil.newArrayList();
        }
        return selectList(new LambdaQueryWrapper<T>().in(field, values));
    }

    /**
     * 查询大于 value 且 小于 value 的集合
     *
     * @param leField 大于的字段名
     * @param geField 小于的字段名
     * @param value   值
     * @return 结果
     */
    @Deprecated
    default List<T> selectList(SFunction<T, ?> leField, SFunction<T, ?> geField, Object value) {
        return selectList(new LambdaQueryWrapper<T>().le(leField, value).ge(geField, value));
    }

    /**
     * 查询所有
     *
     * @param field1 字段名1
     * @param value1 字段值1
     * @param field2 字段名2
     * @param value2 字段值2
     * @return 结果
     */
    default List<T> selectList(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2) {
        return selectList(new LambdaQueryWrapper<T>().eq(field1, value1).eq(field2, value2));
    }

    /**
     * 批量插入，适合大量数据插入
     *
     * @param entities 实体们
     */
    default Boolean insertBatch(Collection<T> entities) {
        return Db.saveBatch(entities);
    }

    /**
     * 批量插入，适合大量数据插入
     *
     * @param entities 实体们
     * @param size     插入数量 Db.saveBatch 默认为 1000
     */
    default Boolean insertBatch(Collection<T> entities, int size) {
        return Db.saveBatch(entities, size);
    }

    /**
     * 批量更新
     *
     * @param update 实体
     * @return 结果
     */
    default int updateBatch(T update) {
        return update(update, new QueryWrapper<>());
    }

    /**
     * 批量更新
     *
     * @param entities 实体集合
     * @return 结果
     */
    default Boolean updateBatch(Collection<T> entities) {
        return Db.updateBatchById(entities);
    }

    /**
     * 批量更新
     *
     * @param entities 实体集合
     * @param size     更新数量 Db.saveBatch 默认为 1000
     * @return 结果
     */
    default Boolean updateBatch(Collection<T> entities, int size) {
        return Db.updateBatchById(entities, size);
    }

    /**
     * 新增/更新 合并方法
     *
     * @param entity 实体
     * @return 结果
     */
    default Boolean insertOrUpdate(T entity) {
        return Db.saveOrUpdate(entity);
    }

    /**
     * 批量新增或更新
     *
     * @param collection 实体集合
     * @return 结果
     */
    default Boolean insertOrUpdateBatch(Collection<T> collection) {
        return Db.saveOrUpdateBatch(collection);
    }

    /**
     * 删除
     *
     * @param field 字段名
     * @param value 字段值
     * @return 结果
     */
    default int delete(String field, String value) {
        return delete(new QueryWrapper<T>().eq(field, value));
    }

    /**
     * 删除
     *
     * @param field 字段名
     * @param value 字段值
     * @return 结果
     */
    default int delete(SFunction<T, ?> field, Object value) {
        return delete(new LambdaQueryWrapper<T>().eq(field, value));
    }

}
