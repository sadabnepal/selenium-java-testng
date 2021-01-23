package com.testnepal.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testnepal.constants.FrameworkConstant;
import com.testnepal.driver.DriverManager;
import com.testnepal.enums.WaitStrategy;

/**
 * Explicit wait factory produces different waits before operating on webelement
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public final class ExplicitWaitFactory {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExplicitWaitFactory() {}
	
	/**
	 * 
	 * @author MD SADAB SAQIB
	 * 23-Jan-2021
	 * @param waitStrategy : Strategy to be applied to find a webelement {@link com.testnepal.enums.WaitStrategy}
	 * @param locator : By locator of the webelement
	 * @return webelement Locates and return the webelement
	 */
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
