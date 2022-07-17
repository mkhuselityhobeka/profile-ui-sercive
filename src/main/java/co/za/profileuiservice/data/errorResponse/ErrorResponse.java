package co.za.profileuiservice.data.errorResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class ErrorResponse {
	
	private LocalDateTime timestamp ;
	private String message;
	private List<String>details;
	
	public ErrorResponse() {}
	public ErrorResponse(String message, List<String> details, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		timestamp.format(dateTimeFormatter);
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		
		this.timestamp = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		timestamp.format(dateTimeFormatter);
			
	}

	@Override
	public int hashCode() {
		return Objects.hash(details, message, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorResponse other = (ErrorResponse) obj;
		return Objects.equals(details, other.details) && Objects.equals(message, other.message)
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "ErrorResponse [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}
	

   

}
