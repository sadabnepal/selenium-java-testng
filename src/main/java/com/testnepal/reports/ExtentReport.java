package com.testnepal.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testnepal.constants.FrameworkConstant;
import com.testnepal.enums.CategoryType;
import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;

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

	public static void flushReports()  {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();

		if(PropertyUtils.getValue(ConfigProperties.AUTOREPORTOPEN).equalsIgnoreCase("yes")) {
			try {
				Desktop.getDesktop().browse(new File(FrameworkConstant.getExtentReportFilePath()).toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void creatTest(String testname) {
		ExtentManager.setExtentTest(extent.createTest(testname));
	}

	public static void addAuthor(String[] authors) {
		for (String author: authors) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}
	}

	public static void addCategories(CategoryType[] categories) {
		for (CategoryType category: categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}
	}

}