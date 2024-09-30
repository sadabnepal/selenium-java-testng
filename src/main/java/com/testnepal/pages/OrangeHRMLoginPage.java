package com.testnepal.pages;

import org.openqa.selenium.By;

import com.testnepal.enums.WaitStrategy;
import com.testnepal.utils.DecodeUtils;

public final class OrangeHRMLoginPage extends BasePage {
	
	private final By textBoxUsername = By.id("txtUsername");
	private final By textBoxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By buttonLogin = By.id("btnLogin");
	
	public OrangeHRMLoginPage enterUsername(String username) {
		doInput(textBoxUsername, username, WaitStrategy.PRESENCE, "Username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		doInput(textBoxPassword, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE, "Password");
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
