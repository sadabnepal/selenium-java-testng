package com.testnepal.exceptions;

@SuppressWarnings("serial")
public final class BrowserInvocationFailedException extends FrameworkExceptions {

	public BrowserInvocationFailedException(String message) {
		super(message);
	}

	public BrowserInvocationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

}
