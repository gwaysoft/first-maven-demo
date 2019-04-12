package com.gwaysoft.firstappdemo.web.ractive.config;

import com.gwaysoft.firstappdemo.web.ractive.repository.UserRepository;
import com.gwaysoft.firstappdemo.web.ractive.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import java.util.Collection;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterFunctionConfiguration {

    /**
     * Spring 5.0 重新定义了服务请求和响应接口
     * 请求接口： ServerRequest
     * 响应接口： ServerResponse
     * 既可以支持Servlet规范，也支持自定义，比如Netty （Web Server）
     * Reactive 的 Flux 或 Mono 可以是异步处理 （非阻塞）
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> findAll(UserRepository userRepository) {

        /*
        Collection<User> users = userRepository.findAll();
        Flux<User> userFlux = Flux.fromIterable(users);
        RouterFunction<ServerResponse> route = RouterFunctions.route()
                .GET("/user/find/all", accept(MediaType.APPLICATION_JSON_UTF8),
                        serverRequest -> ServerResponse.ok().body(userFlux, User.class)).build();
         */

        RouterFunction<ServerResponse> route = RouterFunctions.route()
                .GET("/user/find/all", accept(MediaType.APPLICATION_JSON_UTF8),
                        serverRequest -> {
                            Collection<User> users = userRepository.findAll();
                            Flux<User> userFlux = Flux.fromIterable(users);
                            return ServerResponse.ok().body(userFlux, User.class);
                        }).GET("/user/find/all01", accept(MediaType.APPLICATION_JSON_UTF8),
                        serverRequest -> {
                            Collection<User> users = userRepository.findAll();
                            Flux<User> userFlux = Flux.fromIterable(users);
                            return ServerResponse.ok().body(userFlux, User.class);
                        }).build();
        return route;
        /*
         return RouterFunctions.route(RequestPredicates.GET("/user/find/all"), serverRequest -> {
            Collection<User> users = userRepository.findAll();
            Flux<User> userFlux = Flux.fromIterable(users);
            return ServerResponse.ok().body(userFlux, User.class);
        });
         */
    }
}
