package com.loas.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 所在包：com.loas.gateway.controller
 * 文件名：
 * 项目：com.loas.cloud
 * 功能描述：服务不可用回掉-》》熔断
 * 修改人：xdc
 * 创建时间：2019-08-29 9:20
 */
@RestController
public class Fallbak {

    @RequestMapping(value = "/fallbackcontroller")
    public Map<String, String> fallBackController() {
        Map<String, String> res = new HashMap<>();
        res.put("code", "-100");
        res.put("data", "服务不可用,请检查服务");
        return res;
    }
}
