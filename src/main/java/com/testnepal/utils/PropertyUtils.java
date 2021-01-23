package com.testnepal.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.testnepal.constants.FrameworkConstant;
import com.testnepal.enums.ConfigProperties;
import com.testnepal.exceptions.PropertyFileUsageException;

/**
 * Read the property file and store it in a HashMap for faster processing.
 * Users can prefer to use json instead of property file based on their requirement.
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public final class PropertyUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private PropertyUtils() {}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try(FileInputStream fis = new FileInputStream(FrameworkConstant.getConfigFilePath());) {
			prop.load(fis);
			for(Map.Entry<Object, Object> entry: prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Receives the {@link com.testnepal.enums.ConfigProperties},converts to lower case , return the corresponding value
	 * for the key from the HashMap
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param key : To be fetched from property file
	 * @return corresponding value for the requested key if found else {@link PropertyFileUsageException}
	 */
	public static String getValue(ConfigProperties key) {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name "+key+ " is not found. Please check config file..");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}