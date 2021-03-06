package com.tututu.qa.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 玉麒麟
 * @description Performance VO
 * @createTime 2020年05月18日 09:31:00
 */
@Data
@Builder
public class PerformanceVO {

    private String uuid;
    private String projectNo;
    private String projectName;
    private String apiUuid;
    private String apiName;
    private String apiPath;
    private Integer number;
    private BigDecimal average;
    private BigDecimal ninety;
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal cpu;
    private BigDecimal io;
    private BigDecimal memory;
    private Date createTime;
    private Date updateTime;
}
