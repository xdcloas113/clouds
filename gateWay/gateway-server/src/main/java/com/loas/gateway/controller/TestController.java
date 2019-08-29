package com.loas.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 所在包：com.loas.gateway.controller
 * 文件名：
 * 项目：clouds
 * 创建时间：2019-08-21 15:00
 */
@RestController
public class TestController {

    @Value("${auth.skip.urls}")
    private String [] routes;


    @RequestMapping("/test")
    @ResponseBody
    public String getValue () {
        System.out.println("1");
        return routes.toString();
    }


}
