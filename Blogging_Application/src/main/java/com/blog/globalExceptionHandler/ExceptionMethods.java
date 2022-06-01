package com.blog.globalExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.response.CommonControllerResponse;
import com.blog.response.CommonExceptionResponse;

@RestControllerAdvice
public class ExceptionMethods  {
	private static final long serialVersionUID = 1L;

	public ExceptionMethods() {
		
	}

	@ExceptionHandler(GlobalExcptionHandler.class)
	public CommonExceptionResponse<GlobalExcptionHandler> noSuchElementException(GlobalExcptionHandler ex){
		String message = ex.getMessage();
		String errorCode =ex.getErrorCode();
		HttpStatus status = ex.getStatus();
		CommonExceptionResponse<GlobalExcptionHandler> exception = new CommonExceptionResponse<>(errorCode,message,status);
		return exception;	
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonControllerResponse<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		CommonControllerResponse<Map<String,String>> response = new CommonControllerResponse<>();
		Map<String, String> res = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			res.put(fieldName, message);
			response.setData(res);
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			response.setMessage(message);
		});
		return response;
	}
}
