package com.tututu.qa.controller;

import com.tututu.qa.domain.ProjectApi;
import com.tututu.qa.domain.Result;
import com.tututu.qa.model.ProjectApiIVO;
import com.tututu.qa.service.IProjectAPIService;
import com.tututu.qa.utils.ResultUtil;
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
    public Result<ProjectApiIVO> create(@RequestBody ProjectApiIVO projectApiIVO){
        String uuid = iProjectAPIService.create(projectApiIVO);
        return ResultUtil.success("{}");
    }

    @PostMapping(value = "/update")
    public Result<ProjectApiIVO> update(@RequestBody ProjectApiIVO projectApiIVO){
        iProjectAPIService.update(projectApiIVO);
        return ResultUtil.success("{}");
    }

    @GetMapping(value = "/search")
    public Result<ProjectApi> update(@RequestParam("name") String name){
        List<ProjectApiIVO> projectApiIVOList = iProjectAPIService.searchAPIByName(name);
        Result result = Result.builder().build();
        result.setCode(200);
        result.setMessage("SUCCESS");
        result.setData(projectApiIVOList);
        return result;
    }
}
