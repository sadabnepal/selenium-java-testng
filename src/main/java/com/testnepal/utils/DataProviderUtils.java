package com.testnepal.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.testnepal.constants.FrameworkConstant;

/**
 * Holds the data provider for all the test cases in the framework.
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public final class DataProviderUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DataProviderUtils() {}

	private static List<Map<String, String>> datalist = ExcelUtils.getExcelData("DATA");

	/**
	 * Acts as a data provider for all the test cases.
	 * Parallel=true indicates that each of the iteration will be ran in parallel.
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param m {@link java.lang.reflect.Method} holds the information about the testcases at runtime
	 * @return Object[] containing the List. Each index of the list contains HashMap and each of them
	 * contains the test data needed to run the iterations.
	 * 
	 * @see com.tmb.tests.AmazonDemoTest 
	 * @see com.tmb.listeners.AnnotationTransformer
	 */
	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		if(datalist.isEmpty()) {
			datalist = ExcelUtils.getExcelData(FrameworkConstant.getIterationDataSheetName());
		}

		List<Map<String, String>> requiredDataList = new ArrayList<>();

		for(int i=0; i<datalist.size(); i++) {
			if(datalist.get(i).get("TestName").equalsIgnoreCase(testname) &&
					datalist.get(i).get("Execute").equalsIgnoreCase("yes")) {
				requiredDataList.add(datalist.get(i));
			}
		}

		return requiredDataList.toArray();	
	}
}
