package com.loas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

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
public class AuthServerApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class,args);
    }


//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("guest").password("guest").authorities("WRIGTH_READ")
//                .and()
//                .withUser("admin").password("admin").authorities("WRIGTH_READ", "WRIGTH_WRITE");
//    }
//
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }

}
