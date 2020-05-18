package com.tututu.qa.service;

import com.github.pagehelper.PageInfo;
import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.model.ProjectApiIVO;

import java.util.List;


public interface IProjectAPIService {

    String create(ProjectApiIVO projectApiIVO);
    PageInfo<ProjectApiIVO> getAPIs(PaginationBase paginationBase);
    List<ProjectApiIVO> searchAPIByName(String name);

    void update(ProjectApiIVO projectApiIVO);
}
