package com.tututu.qa.service.impl;

import com.tututu.qa.model.ProjectAPIVO;
import com.tututu.qa.service.IProjectAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Yu QiLin
 * @Description api test
 * @createTime 2020年05月18日 10:24:00
 */
@SpringBootTest
@Slf4j
public class IProjectAPIServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IProjectAPIService iProjectAPIService ;

    @Test
    public void createAPI(){
        ProjectAPIVO projectAPIVO = ProjectAPIVO.builder().build();
        projectAPIVO.setName("api name");
        projectAPIVO.setPath("api name");
        projectAPIVO.setRequest("api name");
        projectAPIVO.setResponse("api name");
        projectAPIVO.setProjectNo("api name");
        projectAPIVO.setProjectName("api name");
        String uuid = iProjectAPIService.create(projectAPIVO);
        log.info(uuid);
    }

    @Test
    public void updateAPI(){
        ProjectAPIVO projectAPIVO = ProjectAPIVO.builder().build();
        projectAPIVO.setUuid("A6CA1FA926AA4717A613EEC229137D18");
        projectAPIVO.setName("api2 name");
        projectAPIVO.setPath("api2 name");
        projectAPIVO.setRequest("api2 name");
        projectAPIVO.setResponse("api2 name");
        projectAPIVO.setProjectNo("api2 name");
        projectAPIVO.setProjectName("api2 name");
        iProjectAPIService.update(projectAPIVO);
    }
}