package com.tututu.qa.repository;

import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.domain.ProjectAPI;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectAPIRepository {
    Integer insert(ProjectAPI projectAPI);
    void update(ProjectAPI projectAPI);

    List<ProjectAPI> getAPIsByPage(PaginationBase paginationBase);
    List<ProjectAPI> queryByName(@Param("name") String name);


}
