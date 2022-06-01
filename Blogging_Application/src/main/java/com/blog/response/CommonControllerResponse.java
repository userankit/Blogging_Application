package com.blog.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonControllerResponse<T> {
	
	@JsonProperty("status_code")
	private HttpStatus statusCode;;
	
	@JsonProperty("message")
	private String message = "No record found";
	
	@JsonProperty("data")
	private T data;

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		if(data!=null) {
			this.setStatusCode(HttpStatus.OK);
			this.setMessage(GlobalUtils.ResponseMessage.success);
		}
		this.data = data;
	}
	

}
