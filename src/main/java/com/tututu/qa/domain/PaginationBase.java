package com.tututu.qa.domain;

import lombok.Getter;
import lombok.Setter;

/**
* @Description: 基础分页
* @Param:
* @return:
* @Author: 玉麒麟
* @Date: 2020-02-23
*/
@Getter
@Setter
public class PaginationBase<T> {
    private int     current;
    private int     pageSize;
    private int     offsetIndex;
    private int     total;
}
