package com.tututu.qa.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Yu QiLin
 * @description Data File
 * @createTime 2020年05月31日 16:00:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataFile {

    String path();  //注解元素 为  id
    String key() default "no description"; //设置默认值，
    String sheet() default "data"; //设置默认值，

}
