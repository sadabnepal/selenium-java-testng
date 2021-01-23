package com.testnepal.utils;

public final class DynamicXpathUtils {

	private DynamicXpathUtils() {}
	
	public static String getDynamicXpath(String xpath, String value) {
		return String.format(xpath, value);
	}
	
	public static String getDynamicXpath(String xpath, String value1, String value2) {
		return String.format(xpath, value1, value2);
	}
}
