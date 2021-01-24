package com.testnepal.reports;

import com.aventstack.extentreports.ExtentTest;
import com.testnepal.driver.Drivers;

/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see Drivers
 */
public class ExtentManager {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();
	
	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	static ExtentTest getExtentTest() {
		return exTest.get();
	}
	
	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 * TODO Disallow null assignment and call unload method instead. 
	 */
	static void setExtentTest(ExtentTest test) {
		exTest.set(test);
	}
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 */
	static void unload() {
		exTest.remove();
	}

}
