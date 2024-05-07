package com.yunxi.module.system.service.dept.impl;

import cn.hutool.core.collection.CollUtil;
import com.yunxi.framework.datapermission.core.annotation.DataPermission;
import com.yunxi.module.system.dal.dataobject.dept.DeptDO;
import com.yunxi.module.system.dal.mapper.dept.DeptMapper;
import com.yunxi.module.system.dal.redis.RedisKeyConstants;
import com.yunxi.module.system.service.dept.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static com.yunxi.framework.common.util.collection.CollectionUtils.convertSet;

/**
 * <p>
 * 部门 Service 实现类
 * </p>
 *
 * @author lidy
 * @since 2024-05-08
 */
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    /**
     * 从缓存中获得所有子部门
     *
     * @param id 父部门编号
     * @return 子部门列表
     */
    @Override
    @DataPermission(enable = false) // 禁用数据权限，避免建立不正确的缓存
    @Cacheable(cacheNames = RedisKeyConstants.DEPT_CHILDREN_ID_LIST, key = "#id")
    public Set<Long> getChildDeptIdListFromCache(Long id) {
        List<DeptDO> children = getChildDeptList(id);
        return convertSet(children, DeptDO::getId);
    }

    /**
     * 获得指定部门的所有子部门
     *
     * @param id 部门编号
     * @return 子部门列表
     */
    @Override
    public List<DeptDO> getChildDeptList(Long id) {
        List<DeptDO> children = new LinkedList<>();
        // 遍历每一层
        Collection<Long> parentIds = Collections.singleton(id);
        for (int i = 0; i < Short.MAX_VALUE; i++) { // 使用 Short.MAX_VALUE 避免 bug 场景下，存在死循环
            // 查询当前层，所有的子部门
            List<DeptDO> depts = deptMapper.selectListByParentId(parentIds);
            // 1. 如果没有子部门，则结束遍历
            if (CollUtil.isEmpty(depts)) {
                break;
            }
            // 2. 如果有子部门，继续遍历
            children.addAll(depts);
            parentIds = convertSet(depts, DeptDO::getId);
        }
        return children;
    }
}
