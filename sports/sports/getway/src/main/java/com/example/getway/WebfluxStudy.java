package com.example.getway;

import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Mono;

public class WebfluxStudy {
    public static void main(String[] args) {
        HttpHandler httpHandler = new HttpHandler() {
            @Override
            public Mono<Void> handle(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
                return null;
            }
        };
        WebHandler webHandler = new WebHandler() {
            @Override
            public Mono<Void> handle(ServerWebExchange serverWebExchange) {

                return null;
            }
        };
    }
}
