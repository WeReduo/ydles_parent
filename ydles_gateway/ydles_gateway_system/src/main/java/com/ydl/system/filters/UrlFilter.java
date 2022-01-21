package com.ydl.system.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * Project Name: ydl_parent
 * File Name: UrlFilter
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/17/上午 9:36
 * Copyright (c) 2022,
 */

@Component
public class UrlFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("经过了第二个过滤器");
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response=exchange.getResponse();
        URI uri=request.getURI();
        String path = uri.getPath();
        System.out.println("path"+path);
        if(path.contains("admin/delete")){
              //logger.warn();
            System.out.println("几点几分那个ip删除管理员");
        }
        //放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
