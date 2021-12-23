package co.com.sofka.mongo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("users")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class UserData {
    private String id;
    private String userName;
    private String userLanguage;
    private String userAction;
    private String userMessage;
}
