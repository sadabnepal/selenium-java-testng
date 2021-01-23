package com.testnepal.exceptions;

@SuppressWarnings("serial")
public class InvalidExcelPathException extends FrameworkExceptions {

	public InvalidExcelPathException(String message) {
		super(message);
	}
	
	public InvalidExcelPathException(String message, Throwable cauase) {
		super(message, cauase);
	}
	
}