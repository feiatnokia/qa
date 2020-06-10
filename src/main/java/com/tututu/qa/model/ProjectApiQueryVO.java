package com.tututu.qa.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author 玉麒麟
 * @description query api
 * @createTime 2020年05月22日 11:04:00
 */
@Data
@Builder
public class ProjectApiQueryVO {

    private int current;
    private int pageSize;
    private String name;
    private String projectNo;
    private String projectName;
}
