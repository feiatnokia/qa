package com.tututu.qa.controller;

import com.tututu.qa.domain.Result;
import com.tututu.qa.model.ProjectVO;
import com.tututu.qa.service.IProjectService;
import com.tututu.qa.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: qa
 * @description:
 * @author: 玉麒麟
 * @create: 2020-02-23 19:19
 **/
@Slf4j
@RequestMapping("project")
@RestController
public class ProjectController {

    IProjectService iProjectService;

    @PostMapping(value = {"/create", "/update"})
    public Result<ProjectVO> createOrUpdateResource(@RequestBody ProjectVO projectVO){
        iProjectService.createOrUpdateProject(projectVO);
        return ResultUtil.success("{}");
    }

}