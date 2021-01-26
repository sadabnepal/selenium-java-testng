package com.testnepal.exceptions;

/**
 * Runtime Exception occurs when failed to invoke browser.
 * 
 * <p>26-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
public final class BrowserInovkationFailedException extends FrameworkExceptions {

	/**
	 * 
	 * @param message : Details about the exception or custom message
	 */
	public BrowserInovkationFailedException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message : Details about the exception or custom message
	 * @param cauase : Pass the enriched stack trace or customized stack trace
	 */
	public BrowserInovkationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

}
