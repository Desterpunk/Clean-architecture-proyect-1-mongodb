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
        UserValidation userValidation = new UserValidation();
        user.setUserMessage("Idioma no encontrado");
        if (user.getUserLanguage().equalsIgnoreCase("es")){
            user.setUserMessage(userMessage.setEsMessage(user));
        }
        if (user.getUserLanguage().equalsIgnoreCase("en")){
            user.setUserMessage(userMessage.setEnMessage(user));
        }
        if (!userValidation.isValid(user.getUserName())){
            user.setUserMessage("Invalid name");
            return Mono.just(user);
        }
        if (!userValidation.isValid(user.getUserLanguage())){
            user.setUserMessage("Invalid language");
            return Mono.just(user);
        }
        if (!userValidation.isValid(user.getUserAction())){
            user.setUserMessage("Invalid Action");
            return Mono.just(user);
        }

        return serviceGateway.createUser(user);
    }
}
