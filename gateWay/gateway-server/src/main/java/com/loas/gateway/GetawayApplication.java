package com.loas.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 所在包：com.loas.gateway
 * 文件名：
 * 项目：clouds
 * 功能描述：
 * 修改人：xdc
 * 修改时间：2018-11-15 10:37
 */
@SpringBootApplication
@EnableEurekaClient
public class GetawayApplication  {
    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class,args);
    }

}