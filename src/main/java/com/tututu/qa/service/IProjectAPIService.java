package com.tututu.qa.service;

import com.github.pagehelper.PageInfo;
import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.model.ProjectAPIVO;

import java.util.List;


public interface IProjectAPIService {

    String create(ProjectAPIVO projectAPIVO);
    PageInfo<ProjectAPIVO> getAPIs(PaginationBase paginationBase);
    List<ProjectAPIVO> searchAPIByName(String name);

    void update(ProjectAPIVO projectAPIVO);
}
