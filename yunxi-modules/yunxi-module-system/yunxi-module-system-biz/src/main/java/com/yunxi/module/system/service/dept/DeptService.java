package com.yunxi.module.system.service.dept;

import com.yunxi.module.system.dal.dataobject.dept.DeptDO;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 部门 Service
 * </p>
 *
 * @author lidy
 * @since 2024-05-08
 */
public interface DeptService {


    /**
     * 从缓存中获得所有子部门
     *
     * @param id 父部门编号
     * @return 子部门列表
     */
    Set<Long> getChildDeptIdListFromCache(Long id);


    /**
     * 获得指定部门的所有子部门
     *
     * @param id 部门编号
     * @return 子部门列表
     */
    List<DeptDO> getChildDeptList(Long id);

}
