package com.tututu.qa.domain;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

/**
 * @description: api
 * @author: 玉麒麟
 * @create: 2020-02-23 19:52
 **/
@Data
@Builder
public class ProjectApi {
    private Long id;
    private String uuid;
    private String name;
    private String path;
    private String request;
    private String response;
    private String projectNo;
    private String projectName;
    private Date createTime;
    private Date updateTime;
}
