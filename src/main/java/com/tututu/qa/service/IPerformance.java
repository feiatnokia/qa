package com.tututu.qa.service;

import com.tututu.qa.model.PerformanceVO;

/**
 * @author Yu QiLin
 * @Description Performance DAO
 * @createTime 2020年05月18日 14:18:00
 */
public interface IPerformance {
    String createPerformanceItem(PerformanceVO performanceVO);

    void updatePerformanceItem(PerformanceVO performanceVO);

    PerformanceVO getPerformanceItemByUuid(String uuid);
}
