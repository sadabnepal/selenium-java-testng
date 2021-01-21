package com.testnepal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testnepal.driver.DriverManager;
import com.testnepal.enums.WaitStrategy;
import com.testnepal.factories.ExplicitWaitFactory;
import com.testnepal.reports.ExtentLogger;

public class BasePage {

	protected void doClick(By locator, WaitStrategy waitStrategy, String elementName) {
		WebElement elem = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
		elem.click();
		ExtentLogger.pass("Clicked on "+elementName +" successfully", true);
	}

	protected void doInput(By locator, String inputText, WaitStrategy waitStrategy, String elementName) {
		WebElement elem = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
		elem.sendKeys(inputText);
		ExtentLogger.pass("Entered '" + inputText + "' successfully in "+elementName, true);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected String getPageUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

}
