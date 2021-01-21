package com.testnepal.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.testnepal.constants.FrameworkConstant;

public final class DataProviderUtils {

	private DataProviderUtils() {}
	private static List<Map<String, String>> datalist = ExcelUtils.getExcelData("DATA");

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
