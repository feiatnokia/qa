package com.tututu.qa.domain;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yu QiLin
 * @Description performance list
 * @createTime 2020年05月18日 09:20:00
 */
@Data
@Builder
public class Performance {

    public Long id;
    public String uuid;
    public String projectNo;
    public String projectName;
    public String apiUuid;
    public String apiName;
    public String apiPath;
    public Integer number;
    public BigDecimal average;
    public BigDecimal ninety;
    public BigDecimal min;
    public BigDecimal max;
    public BigDecimal cpu;
    public BigDecimal memory;
    public BigDecimal io;
    public Date createTime;
    public Date updateTime;
}
