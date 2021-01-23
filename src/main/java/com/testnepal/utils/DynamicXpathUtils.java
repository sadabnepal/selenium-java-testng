package com.testnepal.utils;

/**
 * Constructs a dynamic xpath at run time.
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public final class DynamicXpathUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DynamicXpathUtils() {}
	
	/**
	 * Receives a wildcard string, replace the wildcard with the value and return to the caller
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param xpath : Xpath with wildcard string
	 * @param value : value to be replaced in place of wildcard
	 * @return dynamic xpath string
	 */
	public static String getDynamicXpath(String xpath, String value) {
		return String.format(xpath, value);
	}
	
	/**
	 * Receives a wildcard string, replace the wildcard with the value and return to the caller
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param xpath : Xpath with wildcard string
	 * @param value1 : value to be replaced in place of wildcard
	 * @param value2 : value to be replaced in place of wildcard
	 * @return dynamic xpath string
	 */
	public static String getDynamicXpath(String xpath, String value1, String value2) {
		return String.format(xpath, value1, value2);
	}
}
