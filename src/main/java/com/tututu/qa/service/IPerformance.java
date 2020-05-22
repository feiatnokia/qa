package com.tututu.qa.service;

import com.tututu.qa.domain.Performance;
import com.tututu.qa.model.PerformanceQueryVO;
import com.tututu.qa.model.PerformanceVO;

import java.util.List;

/**
 * @author Yu QiLin
 * @description Performance DAO
 * @createTime 2020年05月18日 14:18:00
 */
public interface IPerformance {
    String createPerformanceItem(PerformanceVO performanceVO);

    void updatePerformanceItem(PerformanceVO performanceVO);

    PerformanceVO getPerformanceItemByUuid(String uuid);

    List<Performance> getPerformanceItems(PerformanceQueryVO performanceQueryVO);
}
