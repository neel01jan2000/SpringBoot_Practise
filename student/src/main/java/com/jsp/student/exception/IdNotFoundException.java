package com.jsp.student.exception;

public class IdNotFoundException extends RuntimeException {

	private String message="Id is not avilabel";

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundException() {
		super();
	}
	
	@Override
	public String getMessage(){
		return this.message;
		
	}
}
