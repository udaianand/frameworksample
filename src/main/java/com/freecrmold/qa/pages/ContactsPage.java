package com.freecrmold.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrmold.qa.base.TestBase;

public class ContactsPage extends TestBase {

	// 1. Page factory

	@FindBy(xpath = "//*[@id='vContactsForm']/table/tbody/tr[1]/td/table/tbody/tr/td[2]/input[3]")
	WebElement newContactButton;

	@FindBy(xpath = "//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")
	WebElement newContactHoverLink;

	// 2.Initializing the page objects
	// 3.Actions
	// Create New Contact

	// 1. Page factory

	// 2.Initializing the page objects

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions

	public NewContactForm clickNewContact() {
		newContactButton.click();
		return new NewContactForm();

	}

}
