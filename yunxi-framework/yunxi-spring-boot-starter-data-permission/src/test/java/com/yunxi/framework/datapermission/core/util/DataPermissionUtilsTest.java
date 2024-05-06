package com.yunxi.framework.datapermission.core.util;

import com.yunxi.framework.datapermission.core.aop.DataPermissionContextHolder;
import com.yunxi.framework.datapermission.core.utils.DataPermissionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * <p>
 * {@link com.yunxi.framework.datapermission.core.utils.DataPermissionUtils} 单元测试
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public class DataPermissionUtilsTest {

    @Test
    public void testExecuteIgnore() {
        DataPermissionUtils.executeIgnore(() -> assertFalse(DataPermissionContextHolder.get().enable()));
    }

}
