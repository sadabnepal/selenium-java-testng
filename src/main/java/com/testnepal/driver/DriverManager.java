package com.testnepal.driver;

import org.openqa.selenium.WebDriver;

/**
 * <p>Driver class is responsible for handling and thread safety for the webdriver instance. </p>
 * 
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see Drivers
 */
public final class DriverManager {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverManager() {}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/**
	 * 
	 * @author MD SADAB SAQIB
	 * 23-Jan-2021
	 * @return {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}

	/**
	 * 
	 * @author MD SADAB SAQIB
	 * 23-Jan-2021
	 * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.<p>
	 * TODO Disallow null assignment and call unload method instead. public access modifier can be changed to default
	 */
	public static void setDriver(WebDriver driverref) {
		driver.set(driverref);
	}

	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * 
	 * @author MD SADAB SAQIB
	 * 23-Jan-2021
	 * TODO public access modifier can be changed to default
	 */
	public static void unload() {
		driver.remove();
	}

}
