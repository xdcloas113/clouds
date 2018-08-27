package com.test.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created scs on 2018-08-27.
 */

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
//@MapperScan("com.yqy.gateway.dao")
@EnableZuulProxy
public class GetawayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class,args);
    }
}
