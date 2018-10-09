package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Test(priority = 3)
	public void loginPageTitleTest() {
		String Title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(Title, "#1 Free CRM software in the cloud for sales and service");

	}

	@Test(priority = 4)
	public void logoImageTest() {
		boolean flag = loginPage.crmLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2, groups = "Login")
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String Title = homePage.validateHomePageTitle();
		Assert.assertEquals(Title, "CRMPRO");
	}

	@Test(priority = 1, groups = "Login")
	public void loginWithDifferentUser() throws InterruptedException {
		String emp1 = TestUtil.loginData().get("emp1");
		String[] user1 = emp1.split("@");
		homePage = loginPage.login(user1[0], user1[1]);
		String Title1 = homePage.validateHomePageTitle();
		Assert.assertEquals(Title1, "CRMPRO");
		driver.close();
		setUp();
		String emp2 = TestUtil.loginData().get("emp2");
		String[] user2 = emp2.split("@");
		homePage = loginPage.login(user2[0], user2[1]);
		String Title2 = homePage.validateHomePageTitle();
		Assert.assertEquals(Title2, "CRMPRO");

	}

	@Test(priority = 3)
	public void loginTestNewWay() throws InterruptedException {
		homePage = loginPage.loginData("emp3");
		String Title = homePage.validateHomePageTitle();
		Assert.assertEquals(Title, "CRMPRO");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
