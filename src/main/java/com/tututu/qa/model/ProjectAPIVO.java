package com.tututu.qa.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author Yu QiLin
 * @Description API VO
 * @createTime 2020年05月18日 09:31:00
 */
@Data
@Builder
public class ProjectAPIVO {
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
