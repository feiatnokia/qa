package com.tututu.qa.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Yu QiLin
 * @description performance query condition
 * @createTime 2020年05月22日 15:48:00
 */
@Data
@Builder
public class PerformanceQueryVO {
    private int current;
    private int pageSize;
    private String projectNo;
    private String projectName;
    private String apiUuid;
    private String apiName;
}
