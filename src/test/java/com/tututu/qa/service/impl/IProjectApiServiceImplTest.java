package com.tututu.qa.service.impl;

import com.tututu.qa.model.ProjectApiIVO;
import com.tututu.qa.service.IProjectAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author Yu QiLin
 * @Description api test
 * @createTime 2020年05月18日 10:24:00
 */
@SpringBootTest
@Slf4j
public class IProjectApiServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IProjectAPIService iProjectAPIService ;

    @Test
    public void createAPI(){
        ProjectApiIVO projectApiIVO = ProjectApiIVO.builder().build();
        projectApiIVO.setName("api name");
        projectApiIVO.setPath("api name");
        projectApiIVO.setRequest("api name");
        projectApiIVO.setResponse("api name");
        projectApiIVO.setProjectNo("api name");
        projectApiIVO.setProjectName("api name");
        String uuid = iProjectAPIService.create(projectApiIVO);
        log.info(uuid);
    }

    @Test
    public void updateAPI(){
        ProjectApiIVO projectApiIVO = ProjectApiIVO.builder().build();
        projectApiIVO.setUuid("A6CA1FA926AA4717A613EEC229137D18");
        projectApiIVO.setName("api2 name");
        projectApiIVO.setPath("api2 name");
        projectApiIVO.setRequest("api2 name");
        projectApiIVO.setResponse("api2 name");
        projectApiIVO.setProjectNo("api2 name");
        projectApiIVO.setProjectName("api2 name");
        iProjectAPIService.update(projectApiIVO);
    }
}