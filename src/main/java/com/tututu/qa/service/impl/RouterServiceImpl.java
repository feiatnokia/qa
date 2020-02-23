package com.tututu.qa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tututu.qa.domain.PaginationBase;
import com.tututu.qa.domain.Router;
import com.tututu.qa.domain.RouterParam;
import com.tututu.qa.repository.RouterRepository;
import com.tututu.qa.service.IRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: qa
 * @description:
 * @author: 玉麒麟
 * @create: 2020-02-23 20:28
 **/
@Service
public class RouterServiceImpl implements IRouterService {

    @Autowired
    RouterRepository routerRepository;

    @Override
    public boolean createOrUpdateRouter(JSONObject jsonObject) {
        Router router = new Router();
        router.setName(jsonObject.get("name").toString());
        router.setName(jsonObject.get("path").toString());
        routerRepository.insert(router);
        return true;
    }

    @Override
    public PageInfo<Router> getRouters(PaginationBase paginationBase) {
        PageHelper.startPage(paginationBase.getCurrent(), paginationBase.getPageSize());
        List<Router> ls = routerRepository.getRouterByPage(paginationBase);
        PageInfo<Router> routerPageInfo = new PageInfo<>(ls);
        return routerPageInfo;
    }

    @Override
    public List<Router> searchRouterByName(String name) {
        return routerRepository.queryByName(name.trim());
    }
}
