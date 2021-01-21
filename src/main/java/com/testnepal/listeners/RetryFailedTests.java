package com.testnepal.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count=0;
	private int maxRetries=Integer.parseInt(PropertyUtils.getValue(ConfigProperties.FAILEDTESTRETRYCOUNT));

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
