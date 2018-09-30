package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void loginPageTitleTest() {
		String Title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(Title, "#1 Free CRM software in the cloud for sales and service");

	}

	@Test
	public void logoImageTest() {
		boolean flag = loginPage.crmLogo();
		Assert.assertTrue(flag);
	}

	@Test
	public void loginTest() throws InterruptedException {

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String Title = homePage.validateHomePageTitle();
		Assert.assertEquals(Title, "CRMPRO");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
