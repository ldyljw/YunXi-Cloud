package com.yunxi.cremework.ip.core.utils;

import com.yunxi.framework.ip.core.Area;
import com.yunxi.framework.ip.core.enums.AreaTypeEnum;
import com.yunxi.framework.ip.core.utils.AreaUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>
 * {@link com.yunxi.framework.ip.core.utils.AreaUtils} 单元测试
 * </p>
 *
 * @author lidy
 * @since 2024-04-27
 */
public class AreaUtilsTest {

    /**
     * 根据编号获取城市区域信息
     */
    @Test
    public void testGetArea() {
        // 调用：北京
        Area area = AreaUtils.getArea(110100);
        // 断言，比较两个值是否相等
        assertEquals(area.getId(), 110100);
        assertEquals(area.getName(), "北京市");
        assertEquals(area.getType(), AreaTypeEnum.CITY.getType());
        assertEquals(area.getParent().getId(), 110000);
        assertEquals(area.getChildren().size(), 16);
    }

    /**
     * 格式化地区
     */
    @Test
    public void testFormat() {
        assertEquals(AreaUtils.format(110105), "北京 北京市 朝阳区");
        assertEquals(AreaUtils.format(1), "中国");
        assertEquals(AreaUtils.format(2), "蒙古");
    }

}
