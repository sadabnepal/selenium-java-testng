package com.testnepal.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testnepal.driver.Drivers;

public class BaseTest {
	
	protected BaseTest() {}
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) {
		Map<String, String> map = (Map<String, String>)data[0];
		Drivers.initDriver(map.get("Browser"));
	}
	
	@AfterMethod
	protected void tearDown() {
		Drivers.quitDriver();
	}

}