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

/**
 * This class is responsible for setting the remote or local driver variable
 * 
 * 26-Jan-2021
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see com.testnepal.driver.Drivers
 */
public final class DriverFactory {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverFactory() {}

	/**
	 * 
	 * @author MD SADAB SAQIB
	 * <p>26-Jan-2021</p>
	 * @param browser
	 * @return WebDriver varible based on run mode provided in {@link com.testnepal.enums.ConfigProperties}
	 * @throws MalformedURLException
	 */
	public static WebDriver getDriver(String browser) throws MalformedURLException {
		String runmode = PropertyUtils.getValue(ConfigProperties.RUNMODE);
		String remoteHubURL = "http://localhost:4444/wd/hub";
		WebDriver driver = null;

		if(browser.equalsIgnoreCase("chrome")) {	
			if(runmode.equalsIgnoreCase("remote")) {
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
			if(runmode.equalsIgnoreCase("remote")) {
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
			if(runmode.equalsIgnoreCase("remote")) {
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
