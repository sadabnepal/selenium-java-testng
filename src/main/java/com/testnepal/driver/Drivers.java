package com.testnepal.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.testnepal.constants.FrameworkConstant;
import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;

/**
 * <p>Driver class is responsible for invoking and closing the browser. </p>
 * <p>It is also responsible for setting
 * the driver variable to DriverManager which handles the thread safety for the webdriver instance.</p>
 * 
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
				System.setProperty("webdriver.chrome.driver", FrameworkConstant.getChromeDriverPath());
				DriverManager.setDriver(new ChromeDriver());
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FrameworkConstant.getGeckoDriverPath());
				DriverManager.setDriver(new FirefoxDriver());
			} else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.ie.driver", FrameworkConstant.getEdgeDriverPath());
				DriverManager.setDriver(new InternetExplorerDriver());
			}
			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
