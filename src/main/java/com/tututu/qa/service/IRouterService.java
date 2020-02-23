package com.tututu.qa.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.domain.Router;

import java.util.List;


public interface IRouterService {

    boolean createOrUpdateRouter(JSONObject jsonObject);
    PageInfo<Router> getRouters(PaginationBase paginationBase);
    List<Router> searchRouterByName(String name);

}
