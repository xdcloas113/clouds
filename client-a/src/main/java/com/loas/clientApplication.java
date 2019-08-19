package com.loas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 所在包：com.loas
 * 文件名：
 * 项目：clouds
 * 功能描述：
 * 修改人：xdc
 * auth-server的启动类，这里声明类admin有读写权限，guest只有读的权限；
 * passwordEncoder()方法用于声明用户名和密码的加密方式，注：只有Spring Security5.0以后才有。
 *
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableResourceServer
@RestController
//public class clientApplication extends ResourceServerConfigurerAdapter {
public class clientApplication {

    public static void main(String[] args) {
        SpringApplication.run(clientApplication.class,args);
    }


//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/test")
//                .hasAuthority("WRIGTH_READ");
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources
//                .resourceId("WRIGTH")
//                .tokenStore(jwtTokenStore());
//    }
//
//    @Bean
//    protected JwtAccessTokenConverter jwtTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("springcloud123");
//        return converter;
//    }
//
//    @Bean
//    public TokenStore jwtTokenStore() {
//        return new JwtTokenStore(jwtTokenConverter());
//    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println("----------------header----------------");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            System.out.println(key + ": " + request.getHeader(key));
        }
        System.out.println("----------------header----------------");
        return "hellooooooooooooooo!";
    }



}
