package com.testnepal.driver;

import org.openqa.selenium.WebDriver;

/**
 * 
 * 23-Jan-2021
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public final class DriverManager {

	private DriverManager() {

	}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverref) {
		driver.set(driverref);
	}

	public static void unload() {
		driver.remove();
	}

}
