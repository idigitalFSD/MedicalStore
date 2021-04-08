package medical.manage.store.utils;

import java.util.Date;

//Create simple custom error details bean
public class ExceptionResponse {
	
	private int status;
	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse(int i, Date timestamp, String message, String details) {
		super();
		this.status = i;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
