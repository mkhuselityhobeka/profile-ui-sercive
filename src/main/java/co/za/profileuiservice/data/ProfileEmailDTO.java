package co.za.profileuiservice.data;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import co.za.profileuiservice.services.IsEmailValid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString@EqualsAndHashCode
@Component
public class ProfileEmailDTO {

	 
	@NotBlank
	@NotEmpty(message = "Please fill in name field, name cannot be empty")
	private String name;
	@NonNull
	@NotEmpty(message = "Please fill in email field, email cannot be empty")
	@IsEmailValid
	private String email;
	@NonNull
	@NotEmpty(message = "Please fill in message field, message cannot be empty")
	private String message;
	@NonNull
	@NotEmpty(message = "Please fill in message field, message cannot be empty")
	private String subject;
	
	public ProfileEmailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfileEmailDTO(@NotEmpty(message = "Please fill in name field, name cannot be empty") String name,
			@NotEmpty(message = "Please fill in email field, email cannot be empty") String email,
			@NotEmpty(message = "Please fill in message field, message cannot be empty") String message,
			@NotEmpty(message = "Please fill in message field, message cannot be empty") String subject) {
		super();
		this.name = name;
		this.email = email;
		this.message = message;
		this.subject = subject;
	}
	
	
	
	
	
	
}
