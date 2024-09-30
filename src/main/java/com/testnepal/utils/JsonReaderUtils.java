package com.testnepal.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testnepal.constants.FrameworkConstant;
import com.testnepal.enums.ConfigProperties;
import com.testnepal.exceptions.PropertyFileUsageException;

public class JsonReaderUtils {

	private JsonReaderUtils(){}
	
	private static Map<String, String> configMap;
	
	static {
		try {
			configMap = new ObjectMapper().readValue(new File(FrameworkConstant.getTestDataJsonPath()), 
					new TypeReference<HashMap<String,String>>() {});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(configMap.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name " + key + " is not found. Please check config.properties");
		}
		return configMap.get(key.name().toLowerCase());
	}
}
