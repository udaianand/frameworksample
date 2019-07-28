package com.freecrmold.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrmold.qa.base.TestBase;

public class NewContactForm extends TestBase {

	// Page Factory
	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "home_phone")
	WebElement homePhone;

	@FindBy(id = "mobile")
	WebElement mobile;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr/td/input[2]	")
	WebElement save_Button;

	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr/td/input[3]")
	WebElement saveAndCreateAnother_Button;

	// Initialization
	public NewContactForm() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public ContactDetailsPage saveNewContact(String fn, String ln) {

		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		save_Button.click();
		return new ContactDetailsPage();

	}

	public ContactDetailsPage saveNewContact() {

		save_Button.click();
		return new ContactDetailsPage();
	}

}
