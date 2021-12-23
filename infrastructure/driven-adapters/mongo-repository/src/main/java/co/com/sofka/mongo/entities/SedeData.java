package co.com.sofka.mongo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("users")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class SedeData {
    private String id;
    private String userName;
    private String userLanguage;
}
