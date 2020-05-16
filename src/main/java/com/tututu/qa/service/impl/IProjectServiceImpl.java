package com.tututu.qa.service.impl;

import com.tututu.qa.domain.Project;
import com.tututu.qa.model.ProjectVO;
import com.tututu.qa.repository.ProjectRepository;
import com.tututu.qa.service.IProjectService;
import com.tututu.qa.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public IProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void createOrUpdateProject(ProjectVO projectVO) {

        Project project;
        if(projectVO == null){
            return;
        }

        if(StringUtils.isBlank(projectVO.getProjectNo())){
            project = Project.builder()
                    .projectName(projectVO.getProjectName())
                    .projectNo(UUIDUtils.getEightRandom())
                    .avatar(projectVO.getAvatar())
                    .build();
            projectRepository.insert(project);
        } else {
            project = Project.builder()
                    .projectName(projectVO.getProjectName())
                    .projectNo(projectVO.getProjectNo())
                    .avatar(projectVO.getAvatar())
                    .build();
            projectRepository.update(project);
        }


    }
}
