package com.tututu.qa.repository;

import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.domain.Router;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RouterRepository {
    int insert(Router router);
//    int update(Router router);

    List<Router> getRouterByPage(PaginationBase paginationBase);
    List<Router> queryByName(@Param("name") String name);


}
