package com.emp.advice;
import java.util.Map;
import lombok.Data;

@Data
public class BaseResponse<T> {

	String message;
	String status;
	Map<String, String> respMap;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, String> getRespMap() {
		return respMap;
	}
	public void setRespMap(Map<String, String> respMap) {
		this.respMap = respMap;
	}
	
}