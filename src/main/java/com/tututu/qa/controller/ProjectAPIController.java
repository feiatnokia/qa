package com.tututu.qa.controller;

import com.tututu.qa.domain.ProjectAPI;
import com.tututu.qa.domain.Result;
import com.tututu.qa.model.ProjectAPIVO;
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
public class ProjectAPIController {

    IProjectAPIService iProjectAPIService;

    @PostMapping(value = "/create")
    public Result<ProjectAPIVO> create(@RequestBody ProjectAPIVO projectAPIVO){
        String uuid = iProjectAPIService.create(projectAPIVO);
        return ResultUtil.success("{}");
    }

    @PostMapping(value = "/update")
    public Result<ProjectAPIVO> update(@RequestBody ProjectAPIVO projectAPIVO){
        iProjectAPIService.update(projectAPIVO);
        return ResultUtil.success("{}");
    }

    @GetMapping(value = "/search")
    public Result<ProjectAPI> update(@RequestParam("name") String name){
        List<ProjectAPIVO> projectAPIVOList = iProjectAPIService.searchAPIByName(name);
        Result result = Result.builder().build();
        result.setCode(200);
        result.setMessage("SUCCESS");
        result.setData(projectAPIVOList);
        return result;
    }
}
