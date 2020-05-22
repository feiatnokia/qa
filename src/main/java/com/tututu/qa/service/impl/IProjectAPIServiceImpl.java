package com.tututu.qa.service.impl;

import com.github.pagehelper.PageHelper;
import com.tututu.qa.domain.ProjectApi;
import com.tututu.qa.model.ProjectApiQueryVO;
import com.tututu.qa.model.ProjectApiVO;
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
    public String create(ProjectApiVO projectApiVO) {
        ProjectApi projectAPI = ProjectApi.builder().build();
        projectAPI.setName(projectApiVO.getName());
        projectAPI.setPath(projectApiVO.getPath());
        projectAPI.setProjectNo(projectApiVO.getProjectNo());
        projectAPI.setProjectName(projectApiVO.getProjectName());
        projectAPI.setRequest(projectApiVO.getRequest());
        projectAPI.setResponse(projectApiVO.getResponse());
        projectAPI.setUuid(UUIDUtils.uuid());
        Integer i = projectAPIRepository.insert(projectAPI);
        if(i > 0){
            return projectAPI.getUuid();
        } else {
            return "";
        }
    }


    @Override
    public void update(ProjectApiVO projectApiVO) {
        ProjectApi projectAPI = ProjectApi.builder().build();
        projectAPI.setUuid(projectApiVO.getUuid());
        projectAPI.setName(projectApiVO.getName());
        projectAPI.setPath(projectApiVO.getPath());
        projectAPI.setProjectNo(projectApiVO.getProjectNo());
        projectAPI.setProjectName(projectApiVO.getProjectName());
        projectAPI.setRequest(projectApiVO.getRequest());
        projectAPI.setResponse(projectApiVO.getResponse());
        projectAPIRepository.update(projectAPI);

    }

    @Override
    public List<ProjectApi> listApis(ProjectApiQueryVO projectApiQueryVO) {
        PageHelper.startPage(projectApiQueryVO.getCurrent(), projectApiQueryVO.getPageSize());
        return projectAPIRepository.queryByCondition(projectApiQueryVO);
    }
}
