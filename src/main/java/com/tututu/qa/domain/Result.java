package com.tututu.qa.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: qa
 * @description: HTTP求统一返回
 * @author: 玉麒麟
 * @create: 2020-02-22 23:49
 **/
@Setter
@Getter
public class Result<T> {

    //错误码
    private Integer code;

    //提示信息
    private String message;

    //具体内容
    private T Data;
}
