package com.loas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;

/**
 * auth-server的配置类，编写认证授权服务器适配器OAuthConfiguration类，
 * 这里主要指定类客户端ID、密钥，以及权限定义与作用范围的声明，指定类TokenStore为JWT
 */

//@Configuration
//@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {
	
	@Resource
	private AuthenticationManager authenticationManager;
	
	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
        .inMemory()
        .withClient("Api-GatWay-Server")
        .secret("secret")
        .scopes("WRIGTH", "read").autoApprove(true)
        .authorities("WRIGTH_READ", "WRIGTH_WRITE")
        .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code");
    }
	
	@Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
        .tokenStore(jwtTokenStore())
        .tokenEnhancer(jwtTokenConverter())
        .authenticationManager(authenticationManager);
    }

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtTokenConverter());
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("springcloud123");
        return converter;
    }
}