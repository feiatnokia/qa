package com.tututu.qa.domain;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class Project {

    private Long id;
    private String projectNo;
    private String projectName;
    private String avatar;
    private Date createTime;
    private Date updateTime;

}
