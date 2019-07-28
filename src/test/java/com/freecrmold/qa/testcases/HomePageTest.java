package com.freecrmold.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrmold.qa.base.TestBase;
import com.freecrmold.qa.pages.ContactsPage;
import com.freecrmold.qa.pages.HomePage;
import com.freecrmold.qa.pages.LoginPage;
import com.freecrmold.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	// TESTS
	@Test(priority = 1)
	public void validateHomePageTitle_test() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title is not correct");

	}

	@Test(priority = 2)
	public void verifyUserNameLabel() {
		Assert.assertTrue(homePage.verifyUserNameLabel());
	}

	@Test(priority = 3)
	public void viewContacts_test() {
		TestUtil.switchToMainFrame();
		contactsPage = homePage.clickContacts();

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
