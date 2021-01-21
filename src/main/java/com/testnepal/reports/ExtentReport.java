package com.testnepal.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testnepal.constants.FrameworkConstant;

public class ExtentReport {

	private ExtentReport() {}
	private static ExtentReports extent;

	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstant.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Test Nepal Report");
			spark.config().setReportName("Regression Test Result");
		}
	}

	public static void flushReports() throws IOException {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstant.getExtentReportFilePath()).toURI());
	}

	public static void creatTest(String testname) {
		ExtentManager.setExtentTest(extent.createTest(testname));
	}

}