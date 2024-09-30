package com.testnepal.constants;

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
