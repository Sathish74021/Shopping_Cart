package com.sathish.ShoppingCart.ExceptionHandling;

public class UserDefinedException extends RuntimeException {

	private String Message;
	
	public UserDefinedException(String Message) {
		this.Message=Message;
	}
    
	@Override
	public String getMessage() {
		return Message;
	}
	
}
