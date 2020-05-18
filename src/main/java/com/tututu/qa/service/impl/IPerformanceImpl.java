package com.tututu.qa.service.impl;

import com.tututu.qa.model.PerformanceVO;
import com.tututu.qa.repository.PerformanceRepository;
import com.tututu.qa.service.IPerformance;
import com.tututu.qa.service.assembler.PerformanceAssembler;
import com.tututu.qa.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        performanceRepository.insert(PerformanceAssembler.toPerformance(performanceVO));
        return uuid;
    }

    @Override
    public void updatePerformanceItem(PerformanceVO performanceVO) {
        performanceRepository.update(PerformanceAssembler.toPerformance(performanceVO));
    }

    @Override
    public PerformanceVO getPerformanceItemByUuid(String uuid) {

        return null;
    }
}
