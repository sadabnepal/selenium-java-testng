package com.testnepal.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testnepal.driver.Drivers;

/**
 * <p>Acts as a parent class for all the test classes in this framework.
 * All the test classes needs to extend this class. This class is responsible for invoking and terminating
 * browser under test. </p>
 * 3-Jan-2021
 * 
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */

public class BaseTest {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	protected BaseTest() {}
	
	/**
	 * Invokes a new browser instance and loads the respective URL.
	 * @author MD SADAB SAQIB
	 * 23-Jan-2021
	 * @param data Have all the data feeded to the corresponding test method from data provider.In our case,it is
	 * a hashmap containing all the values from the excel sheet.
	 */
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) {
		Map<String, String> map = (Map<String, String>)data[0];
		Drivers.initDriver(map.get("Browser"));
	}
	
	/**
	 * Terminates the browser instance
	 * @author MD SADAB SAQIB
	 * 23-Jan-2021
	 */
	@AfterMethod
	protected void tearDown() {
		Drivers.quitDriver();
	}

}