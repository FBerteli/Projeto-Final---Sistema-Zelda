package com.GatewayService.ZeldaGateway.Routes;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RoutesGateway {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ZeldaAllGames", r -> r.path("/webclient/games")
                        .uri("http://localhost:8090"))
                .route("ZeldaGameId", r -> r.path("/webclient/games/*")
                        .filters(f -> f.rewritePath("/<id>.*", "/${id}"))
                        .uri("http://localhost:8090"))
                .route("AllUser", r -> r.path("/user")
                        .uri("http://localhost:8080"))
                .route("AddUser", r -> r.path("/user/add")
                        .uri("http://localhost:8080"))
                .route("AttUser", r -> r.path("/user/att/*")
                        .filters(f -> f.rewritePath("/<idUser>.*", "/${idUser}"))
                        .uri("http://localhost:8080"))
                .route("DeleteUser", r -> r.path("/user/delete/*")
                        .filters(f -> f.rewritePath("/<idUser>.*", "/${idUser}"))
                        .uri("http://localhost:8080"))
                .build();
    }
}
