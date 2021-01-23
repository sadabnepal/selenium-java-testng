package com.testnepal.constants;

/**
 * <p>URLConstants Constants holds all the constant URL values used within the framework.</p>
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public final class URLConstants {
	
	private URLConstants() {}
	
	private static final String ORANGE_HRM_BASEURL = "https://opensource-demo.orangehrmlive.com/";
	private static final String HOMEPAGE_URL= "index.php/dashboard";
	private static final String INVALID_CRED_URL = "index.php/auth/validateCredentials";
	
	public static String getOrangeHrmBaseurl() {
		return ORANGE_HRM_BASEURL;
	}
	public static String getHomepageUrl() {
		return getOrangeHrmBaseurl()+HOMEPAGE_URL;
	}
	public static String getInvalidCredUrl() {
		return getOrangeHrmBaseurl()+INVALID_CRED_URL;
	}
}
