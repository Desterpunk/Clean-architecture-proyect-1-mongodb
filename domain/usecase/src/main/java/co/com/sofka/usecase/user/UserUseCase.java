package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository serviceGateway;

    public Mono<User> createUser(User user){
        return serviceGateway.createUser(user);
    }
}
