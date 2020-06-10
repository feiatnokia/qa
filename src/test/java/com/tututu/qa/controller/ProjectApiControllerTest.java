package com.tututu.qa.controller;

import com.alibaba.fastjson.JSON;
import com.tututu.qa.common.utils.UUIDUtils;
import com.tututu.qa.model.ProjectApiQueryVO;
import com.tututu.qa.model.ProjectApiVO;
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

import java.nio.charset.Charset;

import static org.testng.Assert.*;

/**
 * @author 玉麒麟
 * @description test cases for project api controller
 * @createTime 2020年05月22日 17:59:00
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ProjectApiControllerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @BeforeMethod
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCreate() throws Exception{
        ProjectApiVO projectApiVO = ProjectApiVO.builder()
                .projectNo(UUIDUtils.getEightRandom())
                .projectName("name")
                .name("api")
                .path("path")
                .request("request")
                .response("response")
                .uuid(UUIDUtils.uuid())
                .build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/project/api/create")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(projectApiVO))).andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testUpdate() throws Exception {
        ProjectApiVO projectApiVO = ProjectApiVO.builder()
                .projectNo(UUIDUtils.getEightRandom())
                .projectName("2name")
                .name("a2pi")
                .path("2path")
                .request("2request")
                .response("r2esponse")
                .uuid("ED4AB08722364F698E4CFEDD0DC0ABC4")
                .build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/project/api/update")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(projectApiVO))).andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testList() throws Exception{
        ProjectApiQueryVO projectApiQueryVO = ProjectApiQueryVO.builder()
                .current(1)
                .pageSize(10)
                .build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/project/api/list")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(projectApiQueryVO))).andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }
}