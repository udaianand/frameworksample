package com.freecrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.util.TestUtil;

public class HomePage {

	WebDriver ldriver;

	// Page factory or Obj repository

	@FindBy(xpath = "//td[contains(text(),'User: Vasu vasuveera')]") // user is hardcoded.
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contacts;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasks;

	// 2.Initializing the page objects
	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// 3. Actions
	public String validateHomePageTitle() {
		return ldriver.getTitle();
	}

	public boolean verifyUserNameLabel() {
		TestUtil.switchToFrame();
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickContacts() {
		contacts.click();
		// TestUtil.clickOn(driver, Contacts, 20);
		return new ContactsPage();

	}

	public void clickOnNewContactLink() {
		// TestUtil.switchToFrame();
		Actions action = new Actions(ldriver);
		action.moveToElement(contacts).build().perform();
		newContactsLink.click();
	}

	public DealsPage clickDeals() {
		deals.click();
		return new DealsPage();
	}

}
