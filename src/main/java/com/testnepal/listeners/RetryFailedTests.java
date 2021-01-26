package com.testnepal.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;

/**
 * Implements {@link IRetryAnalyzer}.
 * Helps in rerunning the failed tests.
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public class RetryFailedTests implements IRetryAnalyzer {

	private int count=0;
	private int maxRetries=Integer.parseInt(PropertyUtils.getValue(ConfigProperties.FAILEDTESTRETRYCOUNT));

	/**
	 * Return true when needs to be retried and false otherwise.
	 * Maximum try can be set from config.properties
	 * Retry will happen if user desires to and set the value in the property file
	 */
	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
		if(PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value = count<maxRetries;
			count++;
		}
		return value;
	}

}
