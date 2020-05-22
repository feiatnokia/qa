package com.tututu.qa.controller;

import com.tututu.qa.common.api.CommonPage;
import com.tututu.qa.common.api.Result;
import com.tututu.qa.domain.Performance;
import com.tututu.qa.model.PerformanceQueryVO;
import com.tututu.qa.model.PerformanceVO;
import com.tututu.qa.service.IPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @description: Performance Controller
 * @author: 玉麒麟
 * @create: 2020-02-23 19:20
 **/
@RestController
@RequestMapping(value = "/performance")
public class PerformanceController {

    @Autowired
    private IPerformance iPerformance;

    @PostMapping(value = "/list")
    public Result getPerformanceItems(@RequestBody PerformanceQueryVO performanceQueryVO){
        List<Performance> list = iPerformance.getPerformanceItems(performanceQueryVO);
        return Result.success(CommonPage.restPage(list));
    }

    @PostMapping(value = "/create")
    public Result createPerformanceItem(@RequestBody PerformanceVO performanceVO){
        String uuid = iPerformance.createPerformanceItem(performanceVO);
        return Result.success(new HashMap(){{ put("uuid", uuid); }});
    }

    @PostMapping(value = "/update")
    public Result updatePerformanceItem(@RequestBody PerformanceVO performanceVO){
        iPerformance.updatePerformanceItem(performanceVO);
        return Result.success("更新完成");
    }

    @PostMapping(value = "/{uuid}/detail")
    public Result<PerformanceVO> getPerformanceItemByUuid(@PathVariable("uuid") String uuid){
        PerformanceVO performanceVO = iPerformance.getPerformanceItemByUuid(uuid);
        return null;
    }
}
