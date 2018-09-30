package com.freecrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

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
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// Login page constructor - How to initialize the Page Factory
	// 2.Initializing the page objects
	// public LoginPage() {
	// // PageFactory.initElements(driver, LoginPage.class);
	// PageFactory.initElements(driver, this);
	// }

	// 3.Actions
	public String validateLoginPageTitle() {
		return ldriver.getTitle();
	}

	public boolean crmLogo() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginBtn.click();
		return new HomePage(ldriver);
	}

}
