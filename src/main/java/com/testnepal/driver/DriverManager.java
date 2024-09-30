package com.testnepal.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverRef) {
		driver.set(driverRef);
	}

	public static void unload() {
		driver.remove();
	}

}
