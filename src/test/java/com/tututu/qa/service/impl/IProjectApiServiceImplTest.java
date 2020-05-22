package com.tututu.qa.service.impl;

import com.tututu.qa.model.ProjectApiQueryVO;
import com.tututu.qa.model.ProjectApiVO;
import com.tututu.qa.service.IProjectAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author Yu QiLin
 * @description api test
 * @createTime 2020年05月18日 10:24:00
 */
@SpringBootTest
@Slf4j
public class IProjectApiServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IProjectAPIService iProjectAPIService ;

    @Test
    public void testCreateAPI(){
        ProjectApiVO projectApiVO = ProjectApiVO.builder().build();
        projectApiVO.setName("api name");
        projectApiVO.setPath("api name");
        projectApiVO.setRequest("api name");
        projectApiVO.setResponse("api name");
        projectApiVO.setProjectNo("api name");
        projectApiVO.setProjectName("api name");
        String uuid = iProjectAPIService.create(projectApiVO);
        log.info(uuid);
    }

    @Test
    public void testUpdateAPI(){
        ProjectApiVO projectApiVO = ProjectApiVO.builder().build();
        projectApiVO.setUuid("A6CA1FA926AA4717A613EEC229137D18");
        projectApiVO.setName("api2 name");
        projectApiVO.setPath("api2 name");
        projectApiVO.setRequest("api2 name");
        projectApiVO.setResponse("api2 name");
        projectApiVO.setProjectNo("api2 name");
        projectApiVO.setProjectName("api2 name");
        iProjectAPIService.update(projectApiVO);
    }

    @Test
    public void testListApis(){
        ProjectApiQueryVO projectApiQueryVO = ProjectApiQueryVO.builder().build();
        projectApiQueryVO.setCurrent(1);
        projectApiQueryVO.setPageSize(10);
        iProjectAPIService.listApis(projectApiQueryVO);
    }
}