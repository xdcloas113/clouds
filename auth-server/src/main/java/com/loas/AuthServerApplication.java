package com.loas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 所在包：com.loas
 * 文件名：
 * 项目：clouds
 * 功能描述：
 * 修改人：xdc
 */
@SpringBootApplication
@EnableEurekaClient
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class,args);
    }
}
