package com.freecrmold.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrmold.qa.base.TestBase;
import com.freecrmold.qa.util.TestUtil;

public class LoginPage extends TestBase {

	// 1. Page factory
	@FindBy(name = "username")
	@CacheLookup
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[contains(@class,'btn btn-small')]")
	WebElement loginBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	// 2.Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Login page constructor - How to initialize the Page Factory
	// 2.Initializing the page objects
	// public LoginPage() {
	// // PageFactory.initElements(driver, LoginPage.class);
	// PageFactory.initElements(driver, this);
	// }

	// 3.Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean crmLogo() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String user, String pwd) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(pwd);
		TestUtil.clickElementByJS(loginBtn, driver);
		return new HomePage();
	}

	public HomePage loginData(String user) throws InterruptedException {
		TestUtil.loginData(user);
		return new HomePage();

	}

}
