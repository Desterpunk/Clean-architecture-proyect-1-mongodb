package co.com.sofka.mongo;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import co.com.sofka.mongo.entities.UserData;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<User, UserData, String, MongoDBRepository>
        implements UserRepository {

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, User.class/* change for domain model */));
    }

    @Override
    public Mono<User> createUser(User user) {
        UserData userData = UserData.builder().userName(user.getUserName())
                .userLanguage(user.getUserLanguage())
                .userAction(user.getUserAction())
                .userMessage(user.getUserMessage())
                .build();
        return repository.save(userData).map(this::toEntity);
    }
}
