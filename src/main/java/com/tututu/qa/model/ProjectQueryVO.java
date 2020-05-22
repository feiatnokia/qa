package com.tututu.qa.model;

import lombok.Builder;
import lombok.Data;

/**
* @description: 基础分页
* @author: 玉麒麟
* @createTime : 2020-02-23
*/
@Data
@Builder
public class ProjectQueryVO {
    private int     current;
    private int     pageSize;
    private int     offsetIndex;
    private int     total;
}
