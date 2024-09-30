package com.testnepal.pages;

import org.openqa.selenium.By;

import com.testnepal.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {

	private final By linkLoginIcon = By.id("welcome");
	private final By linkLogout = By.linkText("Logout");

	public OrangeHRMHomePage clickOnLoggedInUserIcon() {
		doClick(linkLoginIcon, WaitStrategy.CLICKABLE, "Welcome Link");
		return this;
	}

	public OrangeHRMLoginPage clickOnLogout() {
		doClick(linkLogout, WaitStrategy.CLICKABLE, "Logout Button");
		return new OrangeHRMLoginPage();
	}
	
	public String getUrl() {
		return getPageUrl();
	}
}
