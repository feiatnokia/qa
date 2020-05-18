package com.tututu.qa.controller;

import com.mysql.cj.util.StringUtils;
import com.tututu.qa.domain.ProjectApi;
import com.tututu.qa.common.api.Result;
import com.tututu.qa.model.ProjectApiIVO;
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
    public Result create(@RequestBody ProjectApiIVO projectApiIVO){
        String uuid = iProjectAPIService.create(projectApiIVO);
        if(StringUtils.isNullOrEmpty(uuid)){
            return Result.failed();
        }
        return Result.success(uuid);
    }

    @PostMapping(value = "/update")
    public Result update(@RequestBody ProjectApiIVO projectApiIVO){
        iProjectAPIService.update(projectApiIVO);
        return Result.success("更新完成");
    }

    @GetMapping(value = "/search")
    public Result<List<ProjectApiIVO>> update(@RequestParam("name") String name){
        List<ProjectApiIVO> projectApiIVOList = iProjectAPIService.searchAPIByName(name);
        return Result.success(projectApiIVOList);
    }
}
