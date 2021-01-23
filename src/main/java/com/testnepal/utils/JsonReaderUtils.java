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

/**
 * To construct the map by the reading the config values from JSON. Not used in this framework but can be leveraged
 * instead of property file based on the requirements
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see PropertyUtils
 */
public class JsonReaderUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
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

	/**
	 * Receives the {@link com.testnepal.enums.ConfigProperties},converts to lower case , return the corresponding value
	 * for the key from the HashMap
	 * 
	 * @author MD SADAB SAQIB
	 * 24-Jan-2021
	 * @param key : To be fetched from json file
	 * @return corresponding value for the requested key if found else {@link PropertyFileUsageException}
	 */
	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(configMap.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name " + key + " is not found. Please check config.properties");
		}
		return configMap.get(key.name().toLowerCase());
	}
}
