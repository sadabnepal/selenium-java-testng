package com.testnepal.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testnepal.constants.FrameworkConstant;
import com.testnepal.driver.DriverManager;
import com.testnepal.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {}
	
	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By locator) {
		WebElement elem=null;
		if(waitStrategy == WaitStrategy.CLICKABLE) {
			elem = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitWaitTime())
				.until(ExpectedConditions.elementToBeClickable(locator));
		} 
		else if(waitStrategy == WaitStrategy.PRESENCE) {
			elem = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitWaitTime())
				.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		else if(waitStrategy == WaitStrategy.VISIBLE) {
			elem = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitWaitTime())
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		else if(waitStrategy == WaitStrategy.NONE) {
			elem = DriverManager.getDriver().findElement(locator);
		}
		return elem; 
	}

}
