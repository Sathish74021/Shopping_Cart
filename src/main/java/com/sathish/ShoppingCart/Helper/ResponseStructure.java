package com.sathish.ShoppingCart.Helper;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {
	
	String Message;
	int Status;
	T Data;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public T getData() {
		return Data;
	}
	public void setData(T data) {
		Data = data;
	}
	
	

}
