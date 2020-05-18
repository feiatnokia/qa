package com.tututu.qa.domain;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yu QiLin
 * @description performance list
 * @createTime 2020年05月18日 09:20:00
 */
@Data
@Builder
public class Performance {

    private Long id;
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
    private BigDecimal memory;
    private BigDecimal io;
    private Date createTime;
    private Date updateTime;
}
