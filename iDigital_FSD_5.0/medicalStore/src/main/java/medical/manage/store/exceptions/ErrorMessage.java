package medical.manage.store.exceptions;

import java.util.Date;

public class ErrorMessage {

	private String message;
	private Date timestamp;
private String details;
	public ErrorMessage(String message, Date timestamp,String details) {
		super();
		this.details=details;
		this.message = message;
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}