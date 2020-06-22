package com.tututu.qa.service.impl;

import com.tututu.qa.model.ProjectQueryVO;
import com.tututu.qa.model.ProjectVO;
import com.tututu.qa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 玉麒麟
 * @description TODO
 * @createTime 2020年05月16日 21:37:00
 */
@SpringBootTest
public class IProjectServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IProjectService iProjectService;



    @BeforeClass
    public void init(){

    }

    @Test
    public void testCreate(){
        ProjectVO projectVO = ProjectVO.builder().projectName("test1").avatar(getAvatar()).build();
        iProjectService.createProject(projectVO);
    }

    @Test
    public void testModifyProject(){
        ProjectVO projectVO = ProjectVO.builder().projectNo("61620923").projectName("test2").avatar(getAvatar()).build();
        iProjectService.updateProject(projectVO);
    }

    @Test
    public void testListProjects(){
        ProjectQueryVO projectQueryVO = ProjectQueryVO.builder().current(1).pageSize(10).build();
        List list = iProjectService.listProjects(projectQueryVO);
        System.out.println(list.toString());
    }

    public String getAvatar(){
        List<String> avatarList = new ArrayList<String>();
        avatarList.add("https://gw.alipayobjects.com/zos/rmsportal/WdGqmHpayyMjiEhcKoVE.png");
        avatarList.add("https://gw.alipayobjects.com/zos/rmsportal/zOsKZmFRdUtvpqCImOVY.png");
        avatarList.add("https://gw.alipayobjects.com/zos/rmsportal/dURIMkkrRFpPgTuzkwnB.png");
        avatarList.add("https://gw.alipayobjects.com/zos/rmsportal/sfjbOqnsXXJgNCjCzDBL.png");
        avatarList.add("https://gw.alipayobjects.com/zos/rmsportal/siCrBXXhmvTQGWPNLBow.png");
        avatarList.add("https://gw.alipayobjects.com/zos/rmsportal/kZzEzemZyKLKFsojXItE.png");
        avatarList.add("https://gw.alipayobjects.com/zos/rmsportal/ComBAopevLwENQdKWiIn.png");
        avatarList.add("https://gw.alipayobjects.com/zos/rmsportal/nxkuOJlFJuAUhzlMTCEe.png");

        Random random = new Random();
        Integer integer = random.nextInt(avatarList.size());
        System.out.println(integer);
        return avatarList.get(integer);
    }
}