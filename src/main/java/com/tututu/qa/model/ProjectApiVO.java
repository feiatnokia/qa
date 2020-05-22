package com.tututu.qa.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author Yu QiLin
 * @description API VO
 * @createTime 2020年05月18日 09:31:00
 */
@Data
@Builder
public class ProjectApiVO {
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
