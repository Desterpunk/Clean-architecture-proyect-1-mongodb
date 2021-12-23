package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository serviceGateway;
    public Mono<User> createUser(User user){
        UserMessage userMessage = new UserMessage();
        if (user.getUserLanguage().equalsIgnoreCase("es")){
            user.setUserMessage(userMessage.setEsMessage(user));
        }
        if (user.getUserLanguage().equalsIgnoreCase("en")){
            user.setUserMessage(userMessage.setEnMessage(user));
        }
        return serviceGateway.createUser(user);
    }
}
