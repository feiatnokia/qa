package com.tututu.qa.service.project;

import com.tututu.qa.helper.DataFile;
import com.tututu.qa.helper.DataHelper;
import com.tututu.qa.model.ProjectVO;
import com.tututu.qa.service.IProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 玉麒麟
 * @description run test with data provider csv, yml, excel, xml
 * @createTime 2020年05月31日 16:28:00
 */
@SpringBootTest
@Slf4j
public class ProjectTest extends DataHelper {

    @Autowired
    IProjectService iProjectService;

    @Test(dataProvider = "excel")
    @DataFile(path = "projectData.xlsx")
    public void createProjectWithExcel(Map<String, String> map) {
        String projectName = map.get("projectName");
        String avatar = map.get("avatar");
        log.info("projectName : " + projectName);
        log.info("avatar : " + avatar);
        ProjectVO projectVO = ProjectVO.builder().projectName(projectName).avatar(avatar).build();
        iProjectService.createProject(projectVO);
    }

    @Test(dataProvider = "csv")
    @DataFile(path = "testProject.csv")
    public void createProjectWithCSV(Map<String, String> map) {
        log.info(map.toString());
        String projectName = map.get("projectName");
        String avatar = map.get("avatar");
        log.info("projectName : " + projectName);
        log.info("avatar : " + avatar);
        ProjectVO projectVO = ProjectVO.builder().projectName(projectName).avatar(avatar).build();
        iProjectService.createProject(projectVO);
    }
}
