package com.testnepal.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;
import com.testnepal.utils.ScreenshotUtils;

/**
 * Used for logging the events in the extent report.
 * <p>
 * Encapsulates the unnecessary methods from users
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public class ExtentLogger {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentLogger() {}

	/**
	 * Logs pass event in the extent report
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param msg : custom message that needs to be logged
	 */
	public static void pass(String msg) {
		ExtentManager.getExtentTest().pass(msg);
	}

	/**
	 * Logs fail event in the extent report
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param msg : custom message that needs to be logged
	 */
	public static void fail(String msg) {
		ExtentManager.getExtentTest().fail(msg);
	}

	/**
	 * Logs skip event in the extent report
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param msg : custom message that needs to be logged
	 */
	public static void skip(String msg) {
		ExtentManager.getExtentTest().skip(msg);
	}

	/**
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param message : custom message that needs to be logged
	 * @param isScreenshotNeed : appends screenshot when true ,ignore otherwise
	 */
	public static void pass(String message, boolean isScreenshotNeed) {
		if(PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") 
				&& isScreenshotNeed) {
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			pass(message);
		}
	}

	/**
	 * Logs fail event in the extent report based on user input in property file
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param message : custom message that needs to be logged
	 * @param isScreenshotNeed : appends screenshot when true ,ignore otherwise
	 */
	public static void fail(String message, boolean isScreenshotNeed) {
		if(PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") 
				&& isScreenshotNeed) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			fail(message);
		}
	}

	/**
	 * Logs skip event in the extent report based on user input in property file
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param message : custom message that needs to be logged
	 * @param isScreenshotNeed : appends screenshot when true ,ignore otherwise
	 */
	public static void skip(String message, boolean isScreenshotNeed) {
		if(PropertyUtils.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") 
				&& isScreenshotNeed) {
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			skip(message);
		}
	}

}
