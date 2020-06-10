package com.tututu.qa.controller;

import com.alibaba.fastjson.JSON;
import com.tututu.qa.common.utils.UUIDUtils;
import com.tututu.qa.model.ProjectQueryVO;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.charset.Charset;

/**
 * @author 玉麒麟
 * @description test cases for project controller
 * @createTime 2020年05月22日 17:58:00
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ProjectControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;


    @BeforeMethod
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCreateProject() throws Exception{
        ProjectVO projectVO = ProjectVO.builder().projectNo(UUIDUtils.getEightRandom()).avatar("aaa").projectName("name").build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/project/create")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(projectVO))).andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testUpdateProject() throws Exception {
        ProjectVO projectVO = ProjectVO.builder().projectNo("41562956").avatar("2aaa").projectName("3name").build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/project/update")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(projectVO))).andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testListProjects() throws Exception {
        ProjectQueryVO queryVO = ProjectQueryVO.builder().current(1).pageSize(10).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/project/list")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(queryVO))).andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }
}