package com.testnepal.constants;

import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;

public final class FrameworkConstant {

	private FrameworkConstant() {}

	private static final String RESOURCES_FOLDER_PATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIG_FILE_PATH = RESOURCES_FOLDER_PATH+"/config/config.properties";
	private static final String TEST_DATA_EXCEL_PATH = RESOURCES_FOLDER_PATH+"/excel/testdata.xlsx";
	private static final String TEST_DATA_JSON_PATH = RESOURCES_FOLDER_PATH+"/json/data.json";
	private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir")+"/extent-output/";
	private static final String RUNNER_MANAGER_SHEET_NAME = "RUNNERMANAGER";
	private static final String ITERATION_DATA_SHEET_NAME = "DATA";
	
	private static final int EXPLICIT_WAIT_TIME = 15;
	private static String extentReportFilePath = "";

	public static String getConfigFilePath() {
		return CONFIG_FILE_PATH;
	}

	public static int getExplicitWaitTime() {
		return EXPLICIT_WAIT_TIME;
	}

	public static String getTestDataExcelPath() {
		return TEST_DATA_EXCEL_PATH;
	}

	public static String getTestDataJsonPath() {
		return TEST_DATA_JSON_PATH;
	}

	public static String getRunnerManagerSheetName() {
		return RUNNER_MANAGER_SHEET_NAME;
	}
	
	public static String getIterationDataSheetName() {
		return ITERATION_DATA_SHEET_NAME;
	}
	
	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	public static String getExtentReportFolderPath() {
		return EXTENT_REPORT_FOLDER_PATH;
	}
	
	private static String createReportPath() {
		if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return getExtentReportFolderPath()+System.currentTimeMillis()+"_index.html";
		} else {
			return getExtentReportFolderPath()+"index.html";
		}
	}
}
