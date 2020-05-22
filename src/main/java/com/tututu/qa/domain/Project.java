package com.tututu.qa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private Long id;
    private String projectNo;
    private String projectName;
    private String avatar;
    private Date createTime;
    private Date updateTime;

}
