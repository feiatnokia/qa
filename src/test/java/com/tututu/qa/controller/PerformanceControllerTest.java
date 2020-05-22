package com.tututu.qa.controller;

import com.alibaba.fastjson.JSON;
import com.tututu.qa.common.utils.UUIDUtils;
import com.tututu.qa.domain.Performance;
import com.tututu.qa.model.PerformanceQueryVO;
import com.tututu.qa.model.PerformanceVO;
import com.tututu.qa.model.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.nio.charset.Charset;

import static org.testng.Assert.*;

/**
 * @author Yu QiLin
 * @description test cases for performance data controller
 * @createTime 2020年05月22日 17:59:00
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class PerformanceControllerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @BeforeMethod
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCreatePerformanceItem() throws Exception {
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
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/performance/create")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(performanceVO))).andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testUpdatePerformanceItem() throws Exception{
        PerformanceVO performanceVO = PerformanceVO.builder()
                .uuid("908F036D02FF490ABE89B2A153781B87")
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
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/performance/update")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(performanceVO))).andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testGetPerformanceItems() throws Exception{
        PerformanceQueryVO performanceQueryVO = PerformanceQueryVO.builder()
                .current(1)
                .pageSize(10)
                .build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/performance/list")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(performanceQueryVO))).andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }
}