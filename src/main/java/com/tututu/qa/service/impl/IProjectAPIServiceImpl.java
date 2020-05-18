package com.tututu.qa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.domain.ProjectApi;
import com.tututu.qa.model.ProjectApiIVO;
import com.tututu.qa.repository.ProjectApiRepository;
import com.tututu.qa.service.IProjectAPIService;
import com.tututu.qa.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: Project API service
 * @author: 玉麒麟
 * @create: 2020-02-23 20:28
 **/
@Service
@Transactional
public class IProjectAPIServiceImpl implements IProjectAPIService {

    private final ProjectApiRepository projectAPIRepository;

    @Autowired
    public IProjectAPIServiceImpl(ProjectApiRepository projectAPIRepository){
        this.projectAPIRepository = projectAPIRepository;
    }

    @Override
    public String create(ProjectApiIVO projectApiIVO) {
        ProjectApi projectAPI = ProjectApi.builder().build();
        projectAPI.setName(projectApiIVO.getName());
        projectAPI.setPath(projectApiIVO.getPath());
        projectAPI.setProjectNo(projectApiIVO.getProjectNo());
        projectAPI.setProjectName(projectApiIVO.getProjectName());
        projectAPI.setRequest(projectApiIVO.getRequest());
        projectAPI.setResponse(projectApiIVO.getResponse());
        projectAPI.setUuid(UUIDUtils.uuid());
        Integer i = projectAPIRepository.insert(projectAPI);
        if(i > 0){
            return projectAPI.getUuid();
        } else {
            return "";
        }
    }

    @Override
    public PageInfo<ProjectApiIVO> getAPIs(PaginationBase paginationBase) {
        PageHelper.startPage(paginationBase.getCurrent(), paginationBase.getPageSize());
        List<ProjectApi> ls = projectAPIRepository.getAPIsByPage(paginationBase);
        PageInfo<ProjectApi> projectAPIPageInfo = new PageInfo<>(ls);
        return null;
    }

    @Override
    public List<ProjectApiIVO> searchAPIByName(String name) {
        return null;
    }

    @Override
    public void update(ProjectApiIVO projectApiIVO) {
        ProjectApi projectAPI = ProjectApi.builder().build();
        projectAPI.setUuid(projectApiIVO.getUuid());
        projectAPI.setName(projectApiIVO.getName());
        projectAPI.setPath(projectApiIVO.getPath());
        projectAPI.setProjectNo(projectApiIVO.getProjectNo());
        projectAPI.setProjectName(projectApiIVO.getProjectName());
        projectAPI.setRequest(projectApiIVO.getRequest());
        projectAPI.setResponse(projectApiIVO.getResponse());
        projectAPIRepository.update(projectAPI);

    }
}
