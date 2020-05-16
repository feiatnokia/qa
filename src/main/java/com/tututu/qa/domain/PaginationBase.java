package com.tututu.qa.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
* @Description: 基础分页
* @Author: 玉麒麟
* @Date: 2020-02-23
*/
@Data
@Builder
public class PaginationBase<T> {
    private int     current;
    private int     pageSize;
    private int     offsetIndex;
    private int     total;
}
