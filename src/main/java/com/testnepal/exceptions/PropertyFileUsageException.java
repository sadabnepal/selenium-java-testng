package com.testnepal.exceptions;

/**
 * Runtime Exception occurs when the key or value fetched from the property file is null
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see com.testnepal.constants.FrameworkConstants
 * @see com.testnepal.utils.PropertyUtils
 */
@SuppressWarnings("serial")
public class PropertyFileUsageException extends FrameworkExceptions {

	/**
	 * 
	 * @param message : Details about the exception or custom message
	 */
	public PropertyFileUsageException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message : Details about the exception or custom message
	 * @param cause : Pass the enriched stacktrace or customized stacktrace
	 */
	public PropertyFileUsageException(String message, Throwable cause) {
		super(message, cause);
	}

}
