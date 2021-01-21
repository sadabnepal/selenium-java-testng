package com.testnepal.pages;

import org.openqa.selenium.By;

import com.testnepal.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {
	
	private final By textboxUsername = By.id("txtUsername");
	private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By buttonLogin = By.id("btnLogin");
	
	public OrangeHRMLoginPage enterUsername(String username) {
		doInput(textboxUsername, username, WaitStrategy.PRESENCE, "Username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String pwd) {
		doInput(textboxPassword, pwd, WaitStrategy.PRESENCE, "Password");
		return this;
	}
	
	public OrangeHRMHomePage clickLoginBtn() {
		doClick(buttonLogin, WaitStrategy.CLICKABLE, "Login Button");
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}
}
