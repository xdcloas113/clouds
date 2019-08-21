package com.loas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所在包：com.loas.controller
 * 文件名：
 * 功能描述：
 * 创建时间：2019-08-21 14:29
 */
@RestController
public class TestController {

    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        return  "client-a的get";
    }
}
