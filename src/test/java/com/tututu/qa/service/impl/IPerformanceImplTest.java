package com.tututu.qa.service.impl;

import com.tututu.qa.domain.Performance;
import com.tututu.qa.model.PerformanceQueryVO;
import com.tututu.qa.model.PerformanceVO;
import com.tututu.qa.service.IPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Yu QiLin
 * @Description performance test case
 * @createTime 2020年05月18日 16:13:00
 */
@SpringBootTest
public class IPerformanceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    IPerformance iPerformance;

    @Test
    public void testCreatePerformanceItem() {
        PerformanceVO performanceVO = PerformanceVO.builder()
                .projectNo("61620923")
                .projectName("test2")
                .apiUuid("E30BA8E7101644239DE0D7853FF13A5A")
                .apiName("apiName")
                .apiPath("/qa/test/add")
                .average(BigDecimal.TEN)
                .ninety(BigDecimal.TEN)
                .number(10)
                .min(BigDecimal.TEN)
                .max(BigDecimal.TEN)
                .cpu(BigDecimal.TEN)
                .memory(BigDecimal.TEN)
                .io(BigDecimal.ONE)
                .build();
        iPerformance.createPerformanceItem(performanceVO);
    }

    @Test
    public void testUpdatePerformanceItem() {
        PerformanceVO performanceVO = PerformanceVO.builder()
                .uuid("3C6044117D1A415BBF32D100CB81B4FD")
                .projectNo("61620923")
                .projectName("test2")
                .apiUuid("E30BA8E7101644239DE0D7853FF13A5A")
                .apiName("apiName")
                .apiPath("/qa/test/add")
                .average(BigDecimal.ONE)
                .ninety(BigDecimal.ONE)
                .number(10)
                .min(BigDecimal.ONE)
                .max(BigDecimal.TEN)
                .cpu(BigDecimal.TEN)
                .memory(BigDecimal.TEN)
                .io(BigDecimal.ONE)
                .build();
        iPerformance.updatePerformanceItem(performanceVO);
    }

    @Test
    public void testGetPerformanceItems() {
        PerformanceQueryVO performanceQueryVO = PerformanceQueryVO.builder().current(1).pageSize(10).build();
        List<Performance> list = iPerformance.getPerformanceItems(performanceQueryVO);
        Assert.assertNotNull(list.get(0).getUuid());
    }
}