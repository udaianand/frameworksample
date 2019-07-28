package com.freecrmold.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrmold.qa.base.TestBase;
import com.freecrmold.qa.util.TestUtil;

public class HomePage extends TestBase {

	// Page factory or Obj repository

	@FindBy(xpath = "//td[contains(text(),'User: Vasu vasuveera')]") // user is hardcoded.
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contacts;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	public static WebElement newContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasks;

	// 2.Initializing the page objects
	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	// 3. Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserNameLabel() {
		TestUtil.switchToMainFrame();
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickContacts() {
		contacts.click();
		// TestUtil.clickOn(driver, Contacts, 20);
		return new ContactsPage();

	}

	public NewContactForm clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newContactsLink.click();
		return new NewContactForm();
	}

	public DealsPage clickDeals() {
		deals.click();
		return new DealsPage();
	}

}
