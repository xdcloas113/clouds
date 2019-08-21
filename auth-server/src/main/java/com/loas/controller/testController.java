package com.loas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所在包：com.loas.controller
 * 文件名：
 * 项目：clouds
 * 功能描述：
 * 修改人：xdc
 * 创建时间：2019-08-20 10:17
 */
@RestController
public class testController {

    @RequestMapping("/get")
    @ResponseBody
    public String getIndex () {
        System.out.println("11");
        return "fack";
    }

    @RequestMapping("/auth/get1")
    @ResponseBody
    public String getIndex2 () {
        System.out.println("进阿里了");
        return "2.0";
    }
}
