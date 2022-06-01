package com.blog.globalExceptionHandler;

import org.springframework.http.HttpStatus;


public class GlobalExcptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public String errorCode;
	public String message;
	public HttpStatus status;
	
	public GlobalExcptionHandler() {
		
	}
	
	public GlobalExcptionHandler(String errorCode, String message, HttpStatus status) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
