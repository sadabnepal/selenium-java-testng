package com.testnepal.exceptions;

/**
 * BaseException for the framework. Extends Runtime Exception and can be thrown anywhere to terminate a program
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
public class FrameworkExceptions extends RuntimeException {


	/**
	 * 
	 * @param message : Details about the exception or custom message
	 */
	public FrameworkExceptions(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message : Details about the exception or custom message
	 * @param cause : Pass the enriched stacktrace or customized stacktrace
	 */
	public FrameworkExceptions(String message, Throwable cause) {
		super(message, cause);
	}
	

}
