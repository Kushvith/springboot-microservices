package com.kushvith.gateway;


import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class MyPrefilter implements GlobalFilter {
    final Logger logger = LoggerFactory.getLogger(MyPrefilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String request = exchange.getRequest().getPath().toString();
        logger.info("the request url is" + request);
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        Set<String> httpheader = httpHeaders.keySet();
        httpheader.forEach((headerNames)->{
                logger.info("header information" + headerNames);
                String headerValues = httpHeaders.getFirst(headerNames);
                logger.info(headerValues);
        }); 
        return chain.filter(exchange);
    }
    
}
