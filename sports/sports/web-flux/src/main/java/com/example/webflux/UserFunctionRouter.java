package com.example.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class UserFunctionRouter {

    @Autowired
    private UserHandler userHandler;

    public RouterFunction router() {
        return null;
    }

}
