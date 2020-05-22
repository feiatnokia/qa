package com.tututu.qa.service;

import com.tututu.qa.domain.Project;
import com.tututu.qa.model.ProjectQueryVO;
import com.tututu.qa.model.ProjectVO;

import java.util.List;

public interface IProjectService {
    String createProject(ProjectVO projectVO);
    void updateProject(ProjectVO projectVO);

    List<Project> listProjects(ProjectQueryVO projectQueryVO);
}
