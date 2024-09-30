package com.testnepal.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.testnepal.constants.FrameworkConstant;

public final class DataProviderUtils {

	private DataProviderUtils() {}

	private static List<Map<String, String>> dataList = ExcelUtils.getExcelData("DATA");

	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testName = m.getName();
		if(dataList.isEmpty()) {
			dataList = ExcelUtils.getExcelData(FrameworkConstant.getIterationDataSheetName());
		}

		List<Map<String, String>> requiredDataList = new ArrayList<>();

		for(int i=0; i<dataList.size(); i++) {
			if(dataList.get(i).get("TestName").equalsIgnoreCase(testName) &&
			dataList.get(i).get("Execute").equalsIgnoreCase("yes")) {
				requiredDataList.add(dataList.get(i));
			}
		}

		return requiredDataList.toArray();	
	}
}
