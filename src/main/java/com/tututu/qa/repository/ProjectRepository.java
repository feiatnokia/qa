package com.tututu.qa.repository;

import com.tututu.qa.domain.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 玉麒麟
 * @description repository interface
 * @createTime 2020年05月16日 15:29:00
 */
@Mapper
@Component
public interface ProjectRepository {
    Integer insert(Project project);

    void update(Project project);

    List<Project> list();
}
