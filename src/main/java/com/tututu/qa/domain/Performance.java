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
