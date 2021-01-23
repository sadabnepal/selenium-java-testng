package com.testnepal.constants;

import com.testnepal.enums.ConfigProperties;
import com.testnepal.utils.PropertyUtils;

/**
 * Framework Constants holds all the constant values used within the framework. If some value needs to be changed
 * or modified often, then it should be stored in the property files.
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public final class FrameworkConstant {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameworkConstant() {}

	private static final String RESOURCES_FOLDER_PATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROME_DRIVER_PATH = RESOURCES_FOLDER_PATH+"/executable/chromedriver.exe";
	private static final String GECKO_DRIVER_PATH = RESOURCES_FOLDER_PATH+"/executable/geckodriver.exe";
	private static final String EDGE_DRIVER_PATH = RESOURCES_FOLDER_PATH+"/executable/msedgedriver.exe";
	private static final String CONFIG_FILE_PATH = RESOURCES_FOLDER_PATH+"/config/config.properties";
	private static final String TEST_DATA_EXCEL_PATH = RESOURCES_FOLDER_PATH+"/excel/testdata.xlsx";
	private static final String TEST_DATA_JSON_PATH = RESOURCES_FOLDER_PATH+"/json/data.json";
	private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir")+"/extent-output/";
	private static final String RUNNER_MANAGER_SHEET_NAME = "RUNNERMANAGER";
	private static final String ITERATION_DATA_SHEET_NAME = "DATA";
	
	private static final int EXPLICIT_WAIT_TIME = 15;
	private static String extentReporFilePath = "";

	public static String getGeckoDriverPath() {
		return GECKO_DRIVER_PATH;
	}

	public static String getEdgeDriverPath() {
		return EDGE_DRIVER_PATH;
	}
	
	public static String getChromeDriverPath() {
		return CHROME_DRIVER_PATH;
	}

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
	
	/**
	 * 
	 * @author MD SADAB SAQIB
	 * <p>23-Jan-2021</p>
	 * @return Extent Report path where the index.html file will be generated.
	 */
	public static String getExtentReportFilePath() {
		if(extentReporFilePath.isEmpty()) {
			extentReporFilePath = createReportPath();
		}
		return extentReporFilePath;
	}
	
	public static String getExtentReportFolderPath() {
		return EXTENT_REPORT_FOLDER_PATH;
	}
	
	/**
	 * 
	 * @author MD SADAB SAQIB
	 * 23-Jan-2021
	 * @return If Override reports value in the 
	 * property file is no,then the timestamp will be appended
	 */
	private static String createReportPath() {
		if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return getExtentReportFolderPath()+System.currentTimeMillis()+"_index.html";
		} else {
			return getExtentReportFolderPath()+"index.html";
		}
	}
}
