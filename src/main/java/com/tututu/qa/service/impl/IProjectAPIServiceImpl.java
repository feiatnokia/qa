package com.tututu.qa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.domain.ProjectAPI;
import com.tututu.qa.model.ProjectAPIVO;
import com.tututu.qa.repository.ProjectAPIRepository;
import com.tututu.qa.service.IProjectAPIService;
import com.tututu.qa.utils.UUIDUtils;
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

    private final ProjectAPIRepository projectAPIRepository;

    @Autowired
    public IProjectAPIServiceImpl(ProjectAPIRepository projectAPIRepository){
        this.projectAPIRepository = projectAPIRepository;
    }

    @Override
    public String create(ProjectAPIVO projectAPIVO) {
        ProjectAPI projectAPI = ProjectAPI.builder().build();
        projectAPI.setName(projectAPIVO.getName());
        projectAPI.setPath(projectAPIVO.getPath());
        projectAPI.setProjectNo(projectAPIVO.getProjectNo());
        projectAPI.setProjectName(projectAPIVO.getProjectName());
        projectAPI.setRequest(projectAPIVO.getRequest());
        projectAPI.setResponse(projectAPIVO.getResponse());
        projectAPI.setUuid(UUIDUtils.uuid());
        projectAPIRepository.insert(projectAPI);
        return projectAPI.getUuid();
    }

    @Override
    public PageInfo<ProjectAPIVO> getAPIs(PaginationBase paginationBase) {
        PageHelper.startPage(paginationBase.getCurrent(), paginationBase.getPageSize());
        List<ProjectAPI> ls = projectAPIRepository.getAPIsByPage(paginationBase);
        PageInfo<ProjectAPI> projectAPIPageInfo = new PageInfo<>(ls);
        return null;
    }

    @Override
    public List<ProjectAPIVO> searchAPIByName(String name) {
        return null;
    }

    @Override
    public void update(ProjectAPIVO projectAPIVO) {
        ProjectAPI projectAPI = ProjectAPI.builder().build();
        projectAPI.setUuid(projectAPIVO.getUuid());
        projectAPI.setName(projectAPIVO.getName());
        projectAPI.setPath(projectAPIVO.getPath());
        projectAPI.setProjectNo(projectAPIVO.getProjectNo());
        projectAPI.setProjectName(projectAPIVO.getProjectName());
        projectAPI.setRequest(projectAPIVO.getRequest());
        projectAPI.setResponse(projectAPIVO.getResponse());
        projectAPIRepository.update(projectAPI);

    }
}
