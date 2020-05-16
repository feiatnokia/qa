package com.tututu.qa.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectVO {
    private String projectNo;
    private String projectName;
    private String avatar;
}
