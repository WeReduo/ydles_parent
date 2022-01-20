package com.ydl.system.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * Project Name: ydles_parent
 * File Name: IpFilter
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/17/上午 9:28
 * Copyright (c) 2022,
 * //黑名单ip拦截
 */
@Component//交由spring创建
public class IpFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //业务逻辑//黑名单ip拦截
        System.out.println("经过了一个过滤器");
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response=exchange.getResponse();
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        System.out.println("ip:"+remoteAddress.getHostName());
        String hostName = remoteAddress.getHostName();
        System.out.println("hostName"+hostName);
        if (hostName.equals("1.1.1.1")){
            //拒绝访问
            response.setStatusCode(HttpStatus.FORBIDDEN)   ; //403 禁止访问
            return  response.setComplete();
        }
        //放行
        return chain.filter(exchange);   //过滤器链条往后走
    }    //指定过滤器顺序,越小越执行
    //过滤器的执行优先级,返回值越小,执行优先级越高
    @Override
    public int getOrder() {
        return 1;
    }
}
