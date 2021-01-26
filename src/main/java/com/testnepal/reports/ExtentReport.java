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

/**
 * Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal 
 * variable for providing thread safety.
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see com.testnepal.listeners.ListenersClass
 * @see com.testnepal.annotations.FrameworkAnnotation
 */
public class ExtentReport {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentReport() {}
	
	private static ExtentReports extent;

	/**
	 * Set the initial configuration for the Extent Reports and decides the report generation path.
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 */
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

	/**
	 * Flushing the reports ensures extent logs are reflected properly. 
	 * Opens the report in the default desktop browser.
	 * Sets the ThreadLocal variable to default value
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 */
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

	/**
	 * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param testname : Test Name that needs to be reflected in the report
	 */
	public static void creatTest(String testname) {
		ExtentManager.setExtentTest(extent.createTest(testname));
	}

	/**
	 * Logs the authors details in the authors view in the extent report.
	 * Gives an clear idea of Authors Vs Percentage success metrics
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param authors : Authors who created a particular test case
	 */
	public static void addAuthor(String[] authors) {
		for (String author: authors) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}
	}

	/**
	 * Adds the category a particular test case belongs to.
	 * Gives an clear idea of Group Vs Percentage success metrics.
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param categories : category a particular test case belongs to.
	 */
	public static void addCategories(CategoryType[] categories) {
		for (CategoryType category: categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}
	}

}