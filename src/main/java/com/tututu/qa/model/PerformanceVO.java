package com.tututu.qa.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yu QiLin
 * @Description Performance VO
 * @createTime 2020年05月18日 09:31:00
 */
@Data
@Builder
public class PerformanceVO {

    public String uuid;
    public String project_no;
    public String project_name;
    public String api_uuid;
    public String api_name;
    public String api_path;
    public Integer number;
    public BigDecimal average;
    public BigDecimal ninety;
    public BigDecimal min;
    public BigDecimal max;
    public BigDecimal cpu;
    public BigDecimal io;
    public BigDecimal memory;
    public Date createTime;
    public Date updateTime;
}
