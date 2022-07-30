package co.za.profileuiservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class AuthServerCredentials {

    private String tokenUrl = "http://localhost:8089/realms/my-profile-realm/protocol/openid-connect/token";
    @Value("${keycloak.resource}")
    private String clientId;
    private String clientSecret="k1tXUwXTmyO3M5QidZSNolAQyFeDytrC";
    private String grant_type="password";
    private String username="mkhuseli";
    private String password="testing123";
}
