package com.testnepal.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.testnepal.constants.FrameworkConstant;
import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;

public final class Drivers {

	private Drivers() {

	}

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
