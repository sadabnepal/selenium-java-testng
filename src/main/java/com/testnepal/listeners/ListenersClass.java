package com.testnepal.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testnepal.annotations.FrameworkAnnotation;
import com.testnepal.reports.ExtentLogger;
import com.testnepal.reports.ExtentReport;

/**
 * 
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 * Mostly used to help in extent report generation
 * 
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public class ListenersClass implements ITestListener, ISuiteListener {

	/**
	 * Initialize the reports with the file name
	 * @see com.testnepal.reports.ExtentReport
	 */
	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	/**
	 * Terminate the reports
	 * @see com.testnepal.reports.ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
			ExtentReport.flushReports();
	}

	/**
	 * Starts a test node for each testng test
	 * @see com.testnepal.reports.ExtentReport
	 * @see com.testnepal.annotations.FrameworkAnnotation
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.creatTest(result.getMethod().getDescription());
		ExtentReport.addAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.category());
	}

	/**
	 * Marks the test as pass and logs it in the report
	 * @see com.testnepal.reports.ExtentLogger
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed =======");
	}

	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report
	 * @see com.testnepal.reports.ExtentLogger
	 * @see com.testnepal.utils.ScreenshotUtils
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " is failed !!!!!!!", true);
		ExtentLogger.fail(result.getThrowable().toString());
	}

	/**
	 * Marks the test as skip and logs it in the report
	 * @see com.testnepal.reports.ExtentLogger
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped =======");
	}

}
