package com.testnepal.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;
import com.testnepal.utils.ScreenshotUtils;

public class ExtentLogger {

	private ExtentLogger() {}

	public static void pass(String msg) {
		ExtentManager.getExtentTest().pass(msg);
	}

	public static void fail(String msg) {
		ExtentManager.getExtentTest().fail(msg);
	}

	public static void skip(String msg) {
		ExtentManager.getExtentTest().skip(msg);
	}

	public static void pass(String message, boolean isScreenshotNeed) {
		if(PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") 
				&& isScreenshotNeed) {
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeed) {
		if(PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") 
				&& isScreenshotNeed) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeed) {
		if(PropertyUtils.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") 
				&& isScreenshotNeed) {
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			skip(message);
		}
	}

}
