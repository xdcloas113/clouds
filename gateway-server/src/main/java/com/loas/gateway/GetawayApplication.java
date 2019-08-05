package com.loas.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


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
@EnableZuulProxy
@EnableOAuth2Sso
public class GetawayApplication   extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class,args);
    }

    //todo : 定义规则
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//        .authorizeRequests()
//        .antMatchers("/login", "/client/**")
//        .permitAll()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .csrf()
//        .disable();
//    }

}