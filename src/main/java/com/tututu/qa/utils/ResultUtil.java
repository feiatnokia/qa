package com.tututu.qa.utils;

import com.tututu.qa.domain.Result;

/**
 * @program: qa
 * @description:
 * @author: 玉麒麟
 * @create: 2020-02-22 23:57
 **/
public class ResultUtil {

    public static Result success(Object object){
        Result result = Result.builder().build();
        result.setCode(200);
        result.setMessage("SUCCESS");
        result.setData(object);
        return result;
    }

    public static Result error(String code, String message){
        Result result = Result.builder().build();
        result.setCode(400);
        result.setMessage(message);
        result.setData("{}");
        return result;
    }
}
