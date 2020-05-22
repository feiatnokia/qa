package com.tututu.qa.service.impl;

import com.github.pagehelper.PageHelper;
import com.tututu.qa.model.ProjectQueryVO;
import com.tututu.qa.domain.Project;
import com.tututu.qa.model.ProjectVO;
import com.tututu.qa.repository.ProjectRepository;
import com.tututu.qa.service.IProjectService;
import com.tututu.qa.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public IProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public String createProject(ProjectVO projectVO) {
        String projectNo = UUIDUtils.getEightRandom();
        Project project = Project.builder()
                .projectName(projectVO.getProjectName())
                .projectNo(projectNo)
                .avatar(projectVO.getAvatar())
                .build();
        Integer i = projectRepository.insert(project);
        if(i > 0){
            return projectNo;
        } else {
            return "";
        }

    }

    @Override
    public void updateProject(ProjectVO projectVO) {

        Project project;
            project = Project.builder()
                    .projectName(projectVO.getProjectName())
                    .projectNo(projectVO.getProjectNo())
                    .avatar(projectVO.getAvatar())
                    .build();
            projectRepository.update(project);
    }

    @Override
    public List<Project> listProjects(ProjectQueryVO projectQueryVO) {
        PageHelper.startPage(projectQueryVO.getCurrent(), projectQueryVO.getPageSize());
        return projectRepository.list();
    }
}
