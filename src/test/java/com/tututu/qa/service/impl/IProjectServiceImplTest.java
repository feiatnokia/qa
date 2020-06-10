package com.tututu.qa.service.impl;

import com.tututu.qa.model.ProjectQueryVO;
import com.tututu.qa.model.ProjectVO;
import com.tututu.qa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author 玉麒麟
 * @description TODO
 * @createTime 2020年05月16日 21:37:00
 */
@SpringBootTest
public class IProjectServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IProjectService iProjectService;

    @Test
    public void testCreate(){
        ProjectVO projectVO = ProjectVO.builder().projectName("test1").avatar("http3").build();
        iProjectService.createProject(projectVO);
    }

    @Test
    public void testModifyProject(){
        ProjectVO projectVO = ProjectVO.builder().projectNo("61620923").projectName("test2").avatar("http4").build();
        iProjectService.updateProject(projectVO);
    }

    @Test
    public void testListProjects(){
        ProjectQueryVO projectQueryVO = ProjectQueryVO.builder().current(1).pageSize(10).build();
        List list = iProjectService.listProjects(projectQueryVO);
        System.out.println(list.toString());
    }
}