package com.tututu.qa.controller;

import com.mysql.cj.util.StringUtils;
import com.tututu.qa.common.api.CommonPage;
import com.tututu.qa.common.api.Result;
import com.tututu.qa.domain.ProjectApi;
import com.tututu.qa.model.ProjectApiQueryVO;
import com.tututu.qa.model.ProjectApiVO;
import com.tututu.qa.service.IProjectAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: Project API Controller
 * @author: 玉麒麟
 * @create: 2020-02-23 19:20
 **/
@RestController
@Slf4j
public class ProjectApiController {

    IProjectAPIService iProjectAPIService;

    @PostMapping(value = "/create")
    public Result create(@RequestBody ProjectApiVO projectApiVO){
        String uuid = iProjectAPIService.create(projectApiVO);
        if(StringUtils.isNullOrEmpty(uuid)){
            return Result.failed();
        }
        return Result.success(uuid);
    }

    @PostMapping(value = "/update")
    public Result update(@RequestBody ProjectApiVO projectApiVO){
        iProjectAPIService.update(projectApiVO);
        return Result.success("更新完成");
    }

    @GetMapping(value = "/list")
    public Result<CommonPage> list(@RequestBody ProjectApiQueryVO projectApiQueryVO){
        List<ProjectApi> list = iProjectAPIService.listApis(projectApiQueryVO);
        return Result.success(CommonPage.restPage(list));
    }
}
