package com.tututu.qa.repository;

import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.domain.ProjectApi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectApiRepository {
    Integer insert(ProjectApi projectAPI);
    void update(ProjectApi projectAPI);

    List<ProjectApi> getAPIsByPage(PaginationBase paginationBase);
    List<ProjectApi> queryByName(@Param("name") String name);


}
