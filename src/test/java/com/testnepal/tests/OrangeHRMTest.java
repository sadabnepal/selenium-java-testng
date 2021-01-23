package com.testnepal.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.testnepal.annotations.FrameworkAnnotation;
import com.testnepal.constants.URLConstants;
import com.testnepal.enums.CategoryType;
import com.testnepal.pages.OrangeHRMHomePage;
import com.testnepal.pages.OrangeHRMLoginPage;

/**
 * <p>Contains the tests related to Orange HRM page.</p>
 * 
 * 23-Jan-2021
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public final class OrangeHRMTest extends BaseTest {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private OrangeHRMTest() {}

	/**
	 * Test Name mentioned here should match the column name "TestName" in excel sheet.This is mandatory to run this
	 * test. Otherwise it will be ignored.
	 * The match has to be there in both of the RUNMANAGER and DATA sheet
	 * Set the authors who have the created the test which will be logged to the reports
	 * Set the category which this particular test case belongs to
	 * 
	 * @author MD SADAB SAQIB
	 * <p>23-Jan-2021</p>
	 * @param data HashMap containing all the values of test data needed to run the tests
	 */
	@FrameworkAnnotation(author = {"Sadab", "Saqib"}, category = { CategoryType.REGRESSION, CategoryType.SMOKE })
	@Test
	public void loginLogoutTest(Map<String, String> data) {
		String expectedLoginPageTitle = new OrangeHRMLoginPage()
				.enterUsername(data.get("Username")).enterPassword(data.get("Password")).clickLoginBtn()
				.clickOnLoggedinUserIcon().clickOnLogout()
				.getTitle();

		Assertions.assertThat(expectedLoginPageTitle).isEqualTo("OrangeHRM");
	}

	@Test
	public void loginTest(Map<String, String> data) {
		String expectedHomePageURL = new OrangeHRMLoginPage()
				.enterUsername(data.get("Username")).enterPassword(data.get("Password")).clickLoginBtn().getUrl();
		
		//Condition to handle validation based on valid and invalid test data
		if(data.get("Username").equalsIgnoreCase("Admin") && data.get("Password").equalsIgnoreCase("admin123")) {
			Assertions.assertThat(expectedHomePageURL)
			.isEqualTo(URLConstants.getHomepageUrl());
			new OrangeHRMHomePage().clickOnLoggedinUserIcon().clickOnLogout();
		} 
		else {
			Assertions.assertThat(expectedHomePageURL)
			.isEqualTo(URLConstants.getInvalidCredUrl());
		}
	}
}
