package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET("/api/usecase/path"), handler::listenGETUseCase)
            .andRoute(POST("/api/usecase/others"), handler::listenPOSTUseCase)
            .andRoute(GET("/api/otherwise/path"), handler::listenGETOtherUseCase)
            .andRoute(POST("/api/user"),handler::createUser);
    }
}
