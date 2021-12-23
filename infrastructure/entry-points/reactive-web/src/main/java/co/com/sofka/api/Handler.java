package co.com.sofka.api;

import co.com.sofka.model.user.User;
import co.com.sofka.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final UserUseCase userUseCase;

    public Mono<ServerResponse> createUser(ServerRequest serverRequest){
        return serverRequest.bodyToMono(User.class).flatMap(userUseCase::createUser).flatMap(currentUser -> ServerResponse.ok()
                .bodyValue(currentUser.getUserMessage()));
    }
}
