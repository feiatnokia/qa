package com.tututu.qa.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @description: hello test
 * @author: 玉麒麟
 * @create: 2020-02-22 21:52
 **/
@RestController
@RequestMapping(value = "/qa")
public class HelloController {

    @GetMapping(value = "/hello/{id}")
    public String hello(@PathVariable("id") Integer id ){
        return "hello" + id;
    }

    @GetMapping(value = "/hello2")
    public String hello2(@RequestParam(value = "id") Integer id ){
        return "hello" + id;
    }
}
