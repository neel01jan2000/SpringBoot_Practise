package com.jsp.student.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
//	here T is generic type
	private T data;
	private String message;
	private int statusCode;
}
