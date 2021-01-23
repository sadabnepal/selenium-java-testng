package com.testnepal.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

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
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				DriverManager.setDriver(new EdgeDriver());
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
