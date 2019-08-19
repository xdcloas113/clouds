package com.loas.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名：
 * 项目：clouds
 * 功能描述：
 * 修改人：xdc
 * 创建时间：2019-08-19 15:47
 */
@RestController
public class TestController {

    @GetMapping("/get")
    @ResponseBody
    public String bb () {
        return "1";
    }
}
