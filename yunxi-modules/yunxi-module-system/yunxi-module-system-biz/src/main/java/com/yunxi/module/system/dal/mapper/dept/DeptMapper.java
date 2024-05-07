package com.yunxi.module.system.dal.mapper.dept;

import com.yunxi.framework.mybatis.core.mapper.BaseMapperX;
import com.yunxi.module.system.dal.dataobject.dept.DeptDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 部门 mapper 接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-08
 */
@Mapper
public interface DeptMapper extends BaseMapperX<DeptDO> {

    /**
     * 根据父级 ID 查询部门集合
     *
     * @param parentIds 父级 ID
     * @return 部门集合
     */
    default List<DeptDO> selectListByParentId(Collection<Long> parentIds) {
        return selectList(DeptDO::getParentId, parentIds);
    }
}
