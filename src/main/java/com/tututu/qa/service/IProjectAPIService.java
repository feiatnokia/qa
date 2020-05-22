package com.tututu.qa.service;

import com.tututu.qa.domain.ProjectApi;
import com.tututu.qa.model.ProjectApiQueryVO;
import com.tututu.qa.model.ProjectApiVO;

import java.util.List;


public interface IProjectAPIService {

    String create(ProjectApiVO projectApiVO);

    void update(ProjectApiVO projectApiVO);

    List<ProjectApi> listApis(ProjectApiQueryVO projectApiQueryVO);
}
