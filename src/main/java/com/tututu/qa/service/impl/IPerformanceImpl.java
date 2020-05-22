package com.tututu.qa.service.impl;

import com.github.pagehelper.PageHelper;
import com.tututu.qa.domain.Performance;
import com.tututu.qa.model.PerformanceQueryVO;
import com.tututu.qa.model.PerformanceVO;
import com.tututu.qa.repository.PerformanceRepository;
import com.tututu.qa.service.IPerformance;
import com.tututu.qa.service.assembler.PerformanceAssembler;
import com.tututu.qa.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yu QiLin
 * @description performance service
 * @createTime 2020年05月18日 14:18:00
 */
@Service
public class IPerformanceImpl implements IPerformance {

    private final PerformanceRepository performanceRepository;

    @Autowired
    public IPerformanceImpl(PerformanceRepository performanceRepository){
        this.performanceRepository = performanceRepository;
    }

    @Override
    public String createPerformanceItem(PerformanceVO performanceVO) {
        String uuid = UUIDUtils.uuid();
        performanceVO.setUuid(uuid);
        Integer i = performanceRepository.insert(PerformanceAssembler.toPerformance(performanceVO));
        if(i > 0){
            return uuid;
        } else {
            return "";
        }
    }

    @Override
    public void updatePerformanceItem(PerformanceVO performanceVO) {
        performanceRepository.update(PerformanceAssembler.toPerformance(performanceVO));
    }

    @Override
    public PerformanceVO getPerformanceItemByUuid(String uuid) {

        return null;
    }

    @Override
    public List<Performance> getPerformanceItems(PerformanceQueryVO performanceQueryVO) {
        PageHelper.startPage(performanceQueryVO.getCurrent(), performanceQueryVO.getPageSize());
        return performanceRepository.queryByCondition(performanceQueryVO);
    }
}
