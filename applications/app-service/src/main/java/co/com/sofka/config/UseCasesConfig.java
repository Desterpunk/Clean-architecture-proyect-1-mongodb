package co.com.sofka.config;

import co.com.sofka.model.user.gateways.UserRepository;
import co.com.sofka.usecase.user.UserUseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.sofka.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {
        public UserUseCase userUseCase(UserRepository userRepository) {
                return new UserUseCase(userRepository);
        }
}
