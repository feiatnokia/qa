package com.tututu.qa.service.assembler;

import com.tututu.qa.domain.Performance;
import com.tututu.qa.model.PerformanceVO;

/**
 * @author Yu QiLin
 * @description to Performance
 * @createTime 2020年05月18日 14:48:00
 */
public class PerformanceAssembler {

    private PerformanceAssembler(){
    }

    public static Performance toPerformance(PerformanceVO performanceVO){
        Performance performance = Performance.builder().build();
        performance.setUuid(performanceVO.getUuid());
        performance.setProjectNo(performanceVO.getProjectNo());
        performance.setProjectName(performanceVO.getProjectName());
        performance.setApiUuid(performanceVO.getApiUuid());
        performance.setApiName(performanceVO.getApiName());
        performance.setApiPath(performanceVO.getApiPath());
        performance.setAverage(performanceVO.getAverage());
        performance.setNinety(performanceVO.getNinety());
        performance.setMin(performanceVO.getMin());
        performance.setMax(performanceVO.getMax());
        performance.setCpu(performanceVO.getCpu());
        performance.setIo(performanceVO.getIo());
        performance.setMemory(performanceVO.getMemory());
        return performance;
    }
}
