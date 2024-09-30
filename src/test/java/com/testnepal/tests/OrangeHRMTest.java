package com.testnepal.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.testnepal.annotations.FrameworkAnnotation;
import com.testnepal.constants.URLConstants;
import com.testnepal.enums.CategoryType;
import com.testnepal.pages.OrangeHRMHomePage;
import com.testnepal.pages.OrangeHRMLoginPage;

public final class OrangeHRMTest extends BaseTest {

	private OrangeHRMTest() {}

	@FrameworkAnnotation(author = {"Sadab", "Saqib"}, category = { CategoryType.REGRESSION, CategoryType.SMOKE })
	@Test
	public void loginLogoutTest(Map<String, String> data) {
		String expectedLoginPageTitle = new OrangeHRMLoginPage()
				.enterUsername(data.get("Username")).enterPassword(data.get("Password")).clickLoginBtn()
				.clickOnLoggedInUserIcon().clickOnLogout()
				.getTitle();

		Assertions.assertThat(expectedLoginPageTitle).isEqualTo("OrangeHRM");
	}

	@FrameworkAnnotation(author = {"Meraj"}, category = { CategoryType.REGRESSION })
	@Test
	public void loginTest(Map<String, String> data) {
		String expectedHomePageURL = new OrangeHRMLoginPage()
				.enterUsername(data.get("Username")).enterPassword(data.get("Password")).clickLoginBtn().getUrl();
		
		//Condition to handle validation based on valid and invalid test data
		if(data.get("Username").equalsIgnoreCase("Admin") && data.get("Password").equalsIgnoreCase("admin123")) {
			Assertions.assertThat(expectedHomePageURL)
			.isEqualTo(URLConstants.getHomepageUrl());
			new OrangeHRMHomePage().clickOnLoggedInUserIcon().clickOnLogout();
		} 
		else {
			Assertions.assertThat(expectedHomePageURL)
			.isEqualTo(URLConstants.getInvalidCredUrl());
		}
	}
}
