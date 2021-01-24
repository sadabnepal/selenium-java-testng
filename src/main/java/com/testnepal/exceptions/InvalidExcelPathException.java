package com.testnepal.exceptions;

/**
 * Runtime Exception occurs when the path given for excel sheet is incorrect.
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see com.testnepal.constants.FrameworkConstant
 */
@SuppressWarnings("serial")
public class InvalidExcelPathException extends FrameworkExceptions {

	/**
	 * 
	 * @param message : Details about the exception or custom message
	 */
	public InvalidExcelPathException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message : Details about the exception or custom message
	 * @param cauase : Pass the enriched stacktrace or customized stacktrace
	 */
	public InvalidExcelPathException(String message, Throwable cauase) {
		super(message, cauase);
	}
	
}
