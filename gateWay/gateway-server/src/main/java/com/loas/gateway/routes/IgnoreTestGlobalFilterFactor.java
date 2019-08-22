package com.loas.gateway.routes;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class IgnoreTestGlobalFilterFactor extends AbstractGatewayFilterFactory<IgnoreTestGlobalFilterFactor.Config> {
    public final static String ATTRIBUTE_IGNORE_TEST_GLOBAL_FILTER = "@ignoreTestGlobalFilter";


    public IgnoreTestGlobalFilterFactor() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return this::filter;
    }

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(ATTRIBUTE_IGNORE_TEST_GLOBAL_FILTER, true);
        return chain.filter(exchange);
    }

    public static class Config {

    }

    @Override
    public String name() {
        return "IgnoreTestGlobalFilter";
    }
}