package com.tututu.qa.service;

import com.tututu.qa.model.ProjectVO;

public interface IProjectService {
    String createProject(ProjectVO projectVO);
    void updateProject(ProjectVO projectVO);
}
