package com.sathish.ShoppingCart.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.sathish.ShoppingCart.Helper.ResponseStructure;

@ControllerAdvice
public class ExceptionHandler extends Exception {

	@org.springframework.web.bind.annotation.ExceptionHandler(UserDefinedException.class)
	public ResponseEntity<ResponseStructure<String>> HandlingException(UserDefinedException definedException) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(definedException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, null, HttpStatus.BAD_REQUEST.value());
	}
}
