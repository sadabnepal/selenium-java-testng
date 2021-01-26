package com.testnepal.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.testnepal.enums.ConfigProperties;
import com.testnepal.exceptions.BrowserInovkationFailedException;
import com.testnepal.factories.DriverFactory;
import com.testnepal.utils.PropertyUtils;

/**
 * <p>Driver class is responsible for invoking and closing the browser. </p>
 * <p>It is also responsible for setting
 * the driver variable to DriverManager which handles the thread safety for the webdriver instance.</p>
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see com.testnepal.tests.BaseTest
 */

public final class Drivers {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private Drivers() {

	}
	/**
	 * 
	 * @author MD SADAB SAQIB
	 * @param browser value will be passed from {@link com.testnepal.tests.BaseTest}. Values can be chrome, firefox and edge
	 */
	public static void initDriver(String browser) {
		if(Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInovkationFailedException("browser invokation failed, please check capablities!!");
			}
			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
		}
	}

	/**
	 * 
	 * @author MD SADAB SAQIB
	 * 23-Jan-2021
	 */
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
