package co.com.sofka.api;

import co.com.sofka.model.user.User;
import co.com.sofka.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class Handler {

    private final UserUseCase userUseCase;

    public Mono<ServerResponse> createUser(ServerRequest serverRequest){
        Mono<User> user = serverRequest.bodyToMono(User.class);

        return user.flatMap(userUseCase::createUser).flatMap(currentUser -> ServerResponse.created(URI
                .create("/api/user".concat(currentUser.getId())))
                .body(BodyInserters.fromValue(currentUser)));
    }
}
