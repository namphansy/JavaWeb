package psn.exception;

import java.util.Date;

public class ErrorDetails {
	private Date errorDate;
	private String message;
	private String details;

	public ErrorDetails(Date errorDate, String message, String details) {
		super();
		this.errorDate = errorDate;
		this.message = message;
		this.details = details;
	}

	public Date getErrorDate() {
		return errorDate;
	}

	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
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
