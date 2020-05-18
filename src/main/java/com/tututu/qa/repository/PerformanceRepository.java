package com.tututu.qa.repository;

import com.tututu.qa.domain.Performance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Yu QiLin
 * @Description TODO
 * @createTime 2020年05月18日 14:29:00
 */
@Mapper
@Component
public interface PerformanceRepository {
    Integer insert(Performance performance);

    void update(Performance performance);
}
