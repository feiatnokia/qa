package com.tututu.qa.repository;

import com.tututu.qa.domain.Performance;
import com.tututu.qa.model.PerformanceQueryVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 玉麒麟
 * @description performance dao
 * @createTime 2020年05月18日 14:29:00
 */
@Mapper
@Component
public interface PerformanceRepository {
    Integer insert(Performance performance);

    void update(Performance performance);

    List<Performance> queryByCondition(PerformanceQueryVO performanceQueryVO);
}
