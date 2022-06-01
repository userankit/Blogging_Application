package com.blog.response;

import org.springframework.http.HttpStatus;

public class CommonExceptionResponse<T> {

	public String errorCode;
	public String message;
	public HttpStatus status;


	public CommonExceptionResponse() {
		super();
	}
	public CommonExceptionResponse(String errorCode,String message,HttpStatus status)  {
		super();
		this.status = status;
		this.message = message;
		this.errorCode = errorCode;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus notFound) {
		this.status = notFound;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
