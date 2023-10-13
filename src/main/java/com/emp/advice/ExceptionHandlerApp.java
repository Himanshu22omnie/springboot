package com.emp.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerApp {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		BaseResponse<?> resp = new BaseResponse<>();
		resp.setMessage("Sorry, your data could not be updated..");
		resp.setStatus("400");
		
		Map<String, String> respMap = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			respMap.put(fieldName, message);
		});
		resp.setRespMap(respMap);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}	
	
	
//@ExceptionHandler({SQLIntegrityConstraintViolationException.class,DataIntegrityViolationException.class})	
//	@ExceptionHandler({Exception.class})
//public ResponseEntity<String> handleIntegrityException(Exception e) {
//	String errMsg = "Integrity constraint violation Exception: " + e.getMessage();
//	return new ResponseEntity<>(errMsg, HttpStatus.BAD_REQUEST);
	
//	BaseResponse<?> resp = new BaseResponse<>();
//	resp.setMessage("Sorry, your data could not be updated..");
//	resp.setStatus("400");
//	
//	String string;
//	e.getBindingResult().getAllErrors().forEach((error) -> {
//		String fieldName = ((FieldError) error).getField();
//		String message = error.getDefaultMessage();
//		respMap.put(fieldName, message);
//	});
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handleIntegrityException() {
		String msg = "Data is already saved";
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
	
}
//}
	
	

	
