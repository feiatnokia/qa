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
public class ProjectAPI {
    public Long id;
    public String uuid;
    public String name;
    public String path;
    public String request;
    public String response;
    public String projectNo;
    public String projectName;
    public Date createTime;
    public Date updateTime;
}
