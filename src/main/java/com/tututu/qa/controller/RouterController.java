package com.tututu.qa.controller;

import com.alibaba.fastjson.JSONObject;
import com.tututu.qa.domain.Result;
import com.tututu.qa.domain.Router;
import com.tututu.qa.service.IRouterService;
import com.tututu.qa.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: qa
 * @description:
 * @author: 玉麒麟
 * @create: 2020-02-23 19:20
 **/
@RestController
@RequestMapping(value = "/qa/router")
@Slf4j
public class RouterController {

    IRouterService iRouterService;

    @PostMapping(value = {"/create", "/update"})
    public Result<Router> createOrUpdateResource(@RequestBody JSONObject jsonObject){
        boolean b = iRouterService.createOrUpdateRouter(jsonObject);
        if(!b){
            log.error("error");
        }
        return ResultUtil.success("{}");
    }

    @GetMapping(value = "/search")
    public Result<Router> searchRouterByName(@RequestParam("name") String name){
        List<Router> routerList = iRouterService.searchRouterByName(name);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("SUCCESS");
        result.setData(routerList);
        return result;
    }
}
