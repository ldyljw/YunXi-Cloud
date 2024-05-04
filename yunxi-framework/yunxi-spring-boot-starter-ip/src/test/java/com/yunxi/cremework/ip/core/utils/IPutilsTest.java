package com.yunxi.cremework.ip.core.utils;

import com.yunxi.framework.ip.core.Area;
import com.yunxi.framework.ip.core.utils.IPUtils;
import org.junit.jupiter.api.Test;
import org.lionsoul.ip2region.xdb.Searcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>
 * {@link com.yunxi.framework.ip.core.utils.IPUtils} 单元测试
 * </p>
 *
 * @author lidy
 * @since 2024-04-27
 */
public class IPutilsTest {

    /**
     * 查询 IP 对应的区域编码
     */
    @Test
    public void testGetAreaId_string() {
        // 120.202.4.0|120.202.4.255|420600
        Integer areaId = IPUtils.getAreaId("120.202.4.50");
        assertEquals(420600, areaId);
    }

    @Test
    public void testGetAreaId_long() throws Exception {
        // 120.203.123.0|120.203.133.255|360900
        long ip = Searcher.checkIP("120.203.123.250");
        Integer areaId = IPUtils.getAreaId(ip);
        assertEquals(360900, areaId);
    }

    @Test
    public void testGetArea_string() {
        // 120.202.4.0|120.202.4.255|420600
        Area area = IPUtils.getArea("120.202.4.50");
        assertEquals("襄阳市", area.getName());
    }

    @Test
    public void testGetArea_long() throws Exception {
        // 120.203.123.0|120.203.133.255|360900
        long ip = Searcher.checkIP("120.203.123.252");
        Area area = IPUtils.getArea(ip);
        assertEquals("宜春市", area.getName());
    }


}
