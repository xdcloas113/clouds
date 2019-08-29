package com.loas.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope //todo: 动态绑定值失效！修改了值可以直接在config里面访问修改的文件没问题
public class TestController {

    @Value("${auth.skip.urls}")
    private String urls;

    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        return  "client-a的get";
    }


    @RequestMapping("/getConfig")
    @ResponseBody
    public String getConfig () {
        return "result:{}"+urls;
    }

}
