package co.com.sofka.model.user;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String userName;
    private String userLanguage;
    private String userAction;
    private String userMessage;
}
