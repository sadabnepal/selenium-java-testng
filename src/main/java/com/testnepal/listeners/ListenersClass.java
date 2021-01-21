package com.testnepal.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testnepal.reports.ExtentLogger;
import com.testnepal.reports.ExtentReport;

public class ListenersClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReports();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.creatTest(result.getMethod().getDescription());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass("======= " + result.getMethod().getMethodName() + " is passed =======");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail("======= " + result.getMethod().getMethodName() + " is failed !!!!!!!", true);
		ExtentLogger.fail(result.getThrowable().toString());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip("======= " + result.getMethod().getMethodName() + " is skipped =======");
	}

}
