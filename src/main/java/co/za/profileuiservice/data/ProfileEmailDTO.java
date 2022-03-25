package co.za.profileuiservice.data;



import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@ToString@EqualsAndHashCode
@Component
public class ProfileEmailDTO {

	 
	
	private String name;
	private String email;
	private String message;
	private String subject;
	
	
}
