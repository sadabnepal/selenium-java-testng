package com.testnepal.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.testnepal.enums.ConfigProperties;
import com.testnepal.exceptions.BrowserInovkationFailedException;
import com.testnepal.factories.DriverFactory;
import com.testnepal.utils.PropertyUtils;

public final class Drivers {

	private Drivers() {

	}

	public static void initDriver(String browser) {
		if(Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInovkationFailedException("browser invocation failed, please check capabilities!!");
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
