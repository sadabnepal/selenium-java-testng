package com.testnepal.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testnepal.constants.FrameworkConstant;

public class JsonReaderUtils {

	@DataProvider(name="JsonTestDataProvider")
	public Object[] readJsonAsMap() throws IOException {
		HashMap<String, Object> map1 = new ObjectMapper()
				.readValue(new File(FrameworkConstant.getTestData1JsonPath()), new TypeReference<HashMap<String, Object>>() {});
		
		HashMap<String, Object> map2= new ObjectMapper()
				.readValue(new File(FrameworkConstant.getTestData2JsonPath()), new TypeReference<HashMap<String, Object>>() {});
		return new Object[] {map1, map2};
	}
}
