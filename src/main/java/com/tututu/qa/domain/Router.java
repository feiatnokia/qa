package com.tututu.qa.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @program: qa
 * @description: 测试路径
 * @author: 玉麒麟
 * @create: 2020-02-23 19:52
 **/
@Getter
@Setter
public class Router {
    public String id;
    public String name;
    public String path;
    public Date createTime;
    public Date updateTime;
}
