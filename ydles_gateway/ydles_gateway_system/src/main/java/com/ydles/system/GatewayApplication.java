package com.ydles.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Project Name: ydl_parent
 * File Name: GatewayApplication
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/16/下午 4:54
 * Copyright (c) 2022,
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
    @Bean
    public KeyResolver ipKeyResolver(){
        return new KeyResolver() {
            //业务逻辑 说明限制说明呢 限制ip
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                String ip =exchange.getRequest().getRemoteAddress().getHostString();
                return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
            }
        };
    }
}