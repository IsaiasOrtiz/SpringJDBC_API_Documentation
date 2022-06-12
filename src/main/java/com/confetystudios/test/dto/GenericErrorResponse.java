package com.confetystudios.test.dto;

import org.springframework.http.HttpStatus;

public class GenericErrorResponse {

	private HttpStatus errorCode;
	private String cause;
	private String message;

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GenericErrorResponse(HttpStatus errorCode, String cause, String message) {
		super();
		this.errorCode = errorCode;
		this.cause = cause;
		this.message = message;
	}

}
