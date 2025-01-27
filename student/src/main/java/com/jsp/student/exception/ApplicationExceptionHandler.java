package com.jsp.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.student.entity.Student;
import com.jsp.student.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setData(e.getMessage());
		rs.setMessage("Id not found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}

}
