package com.tututu.qa.controller;

import com.tututu.qa.common.api.CommonPage;
import com.tututu.qa.domain.Project;
import com.tututu.qa.model.ProjectQueryVO;
import com.tututu.qa.common.api.Result;
import com.tututu.qa.model.ProjectVO;
import com.tututu.qa.service.IProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: Project Controller
 * @author: 玉麒麟
 * @create: 2020-02-23 19:19
 **/
@Slf4j
@RequestMapping("project")
@RestController
public class ProjectController {

    IProjectService iProjectService;

    @PostMapping(value = {"/create"})
    public Result createProject(@RequestBody ProjectVO projectVO){
        iProjectService.createProject(projectVO);
        return Result.success("更新完成");
    }

    @PostMapping(value = {"/update"})
    public Result updateProject(@RequestBody ProjectVO projectVO){
        iProjectService.updateProject(projectVO);
        return Result.success("更新完成");
    }

    @PostMapping(value = {"/list"})
    public Result<CommonPage> listProjects(@RequestBody ProjectQueryVO projectQueryVO){
        List<Project> list = iProjectService.listProjects(projectQueryVO);
        return Result.success(CommonPage.restPage(list));
    }

}