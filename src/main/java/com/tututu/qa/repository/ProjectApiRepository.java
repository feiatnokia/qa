package com.tututu.qa.repository;

import com.tututu.qa.domain.ProjectApi;
import com.tututu.qa.model.ProjectApiQueryVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectApiRepository {
    Integer insert(ProjectApi projectAPI);
    void update(ProjectApi projectAPI);
    List<ProjectApi> queryByCondition(ProjectApiQueryVO projectApiQueryVO);
}
