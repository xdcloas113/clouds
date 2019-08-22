package com.loas.register;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 所在包：com.loas.register
 * 文件名：
 * 项目：Spring-cloud-All
 * 功能描述：
 * 修改人：xdc
 * 创建时间：2019-01-11 17:03
 *
 *  需要关闭csrf spring2.x版本的security默认启用了csrf检验，要在eurekaServer端配置security的csrf检验为false
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();//关闭csrf
        http.authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest()
                .authenticated().and().httpBasic();
        super.configure(http);

    }
}
