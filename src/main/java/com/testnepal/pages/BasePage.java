package com.testnepal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testnepal.driver.DriverManager;
import com.testnepal.enums.WaitStrategy;
import com.testnepal.factories.ExplicitWaitFactory;
import com.testnepal.reports.ExtentLogger;

public class BasePage {

	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param locator : By Locator of the webelement
	 * @param waitStrategy : Strategy to find webelement. Known  strategies {@link com.testnepal.enums.WaitStrategy}
	 * @param elementName : Name of the element that needs to be logged in the report.
	 */
	protected void doClick(By locator, WaitStrategy waitStrategy, String elementName) {
		WebElement elem = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
		elem.click();
		ExtentLogger.pass("Clicked on "+elementName +" successfully", true);
	}

	/**
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param locator : By Locator of the webelement
	 * @param inputText : value to be send the text box
	 * @param waitStrategy : Strategy to find webelement. Known  strategies {@link com.testnepal.enums.WaitStrategy}
	 * @param elementName : Name of the element that needs to be logged in the report.
	 */
	protected void doInput(By locator, String inputText, WaitStrategy waitStrategy, String elementName) {
		WebElement elem = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
		elem.sendKeys(inputText);
		ExtentLogger.pass("Entered '" + inputText + "' successfully in "+elementName, true);
	}

	/**
	 * Return page title of webpage in String
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @return Page title of the webpage where the selenium is currently interacting.
	 */
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	/**
	 * Return current page url as String
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @return Page URL of the webpage where the selenium is currently interacting.
	 */
	protected String getPageUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

}
