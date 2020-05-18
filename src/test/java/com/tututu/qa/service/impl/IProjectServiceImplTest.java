package com.tututu.qa.service.impl;

import com.tututu.qa.model.ProjectVO;
import com.tututu.qa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author Yu QiLin
 * @Description TODO
 * @createTime 2020年05月16日 21:37:00
 */
@SpringBootTest
public class IProjectServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IProjectService iProjectService;

    @Test
    public void addTest(){
        ProjectVO projectVO = ProjectVO.builder().projectName("test1").avatar("http3").build();
        iProjectService.createProject(projectVO);
    }

    @Test
    public void modifyProjectTest(){
        ProjectVO projectVO = ProjectVO.builder().projectNo("61620923").projectName("test2").avatar("http4").build();
        iProjectService.updateProject(projectVO);
    }
}