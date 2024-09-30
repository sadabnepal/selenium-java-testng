package com.testnepal.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {}

	public static WebDriver getDriver(String browser) throws MalformedURLException {
		String runMode = PropertyUtils.getValue(ConfigProperties.RUNMODE);
		String remoteHubURL = "http://localhost:4444/wd/hub";
		WebDriver driver = null;

		if(browser.equalsIgnoreCase("chrome")) {	
			if(runMode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				driver = new RemoteWebDriver(new URL(remoteHubURL), cap);
			}
			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} 
		else if(browser.equalsIgnoreCase("firefox")) {	
			if(runMode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				driver = new RemoteWebDriver(new URL(remoteHubURL), cap);
			}
			else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		} 
		else if(browser.equalsIgnoreCase("edge")) {	
			if(runMode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.EDGE);
				driver = new RemoteWebDriver(new URL(remoteHubURL), cap);
			} 
			else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}
		return driver;
	}
}
