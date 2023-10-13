package com.emp.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandlerApp {
	
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ApiResponse handleConstraintViolation(ConstraintViolationException ex) {
//		//String errMsg = ex.getMessage();
//		//ResponseEntity<String> b = ResponseEntity.internalServerError().body(ex.getMessage();
//		
//		
//		ApiResponse api = new ApiResponse();
//		//api.setMessage(ex.get);
//		return api;
//		
//		
//		//String s = ex.getMessage();
//		
//		
//		//return ResponseEntity.internalServerError().body(ex.getMessage());
//		//return new ResponseEntity<>(errMsg,HttpStatus.BAD_REQUEST);
//		
//	}
	
	
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
		
		
//		public ResponseEntity handleConstraintViolation2(ConstraintViolationException ex) {
//			
//			ApiResponse api = new ApiResponse();
//			
//			Optional<ExceptionHandlerApp> s;
//			api.setMessage(s.get());
//			return null;
			
			
		//}
		
		
		
		
	
}
	
	

	
