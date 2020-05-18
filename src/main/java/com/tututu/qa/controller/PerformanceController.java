package com.tututu.qa.controller;

import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.common.api.Result;
import com.tututu.qa.model.PerformanceVO;
import com.tututu.qa.service.IPerformance;
import org.springframework.web.bind.annotation.*;

/**
 * @description: Performance Controller
 * @author: 玉麒麟
 * @create: 2020-02-23 19:20
 **/
@RestController
public class PerformanceController {

    private IPerformance iPerformance;

    @GetMapping(value = "/performance")
    public Result<PerformanceVO> getPerformanceItems(@RequestBody PaginationBase paginationBase){

        return null;
    }

    @PostMapping(value = "/performance/create")
    public Result<PerformanceVO> createPerformanceItem(@RequestBody PerformanceVO performanceVO){
        String uuid = iPerformance.createPerformanceItem(performanceVO);
        return null;
    }

    @PostMapping(value = "/performance/update")
    public Result<PerformanceVO> updatePerformanceItem(@RequestBody PerformanceVO performanceVO){
        iPerformance.updatePerformanceItem(performanceVO);
        return null;
    }

    @PostMapping(value = "/performance/{uuid}/detail")
    public Result<PerformanceVO> getPerformanceItemByUuid(@PathVariable("uuid") String uuid){
        PerformanceVO performanceVO = iPerformance.getPerformanceItemByUuid(uuid);
        return null;
    }
}
