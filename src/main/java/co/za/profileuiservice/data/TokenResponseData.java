package co.za.profileuiservice.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class TokenResponseData {

    private String access_token;
    private String refresh_token;


}
