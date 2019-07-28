package com.freecrmold.qa.dataloading;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.freecrmold.qa.base.TestBase;
import com.freecrmold.qa.pages.HomePage;
import com.freecrmold.qa.pages.LoginPage;
import com.freecrmold.qa.util.TestUtil;
import com.freecrmold.qa.util.Xls_Reader;

public class ParameterizedContacts extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	@Test(priority = 1)
	void newTest2() throws InterruptedException {
		Xls_Reader xl = new Xls_Reader(
				"D:\\Aanand\\Project\\Selenium_Workspace_Tutorial\\DesignPOMDataDriven1\\src\\main\\java\\com\\freecrm\\qa\\testdata\\MasterData.xlsx");

		int rowCount = xl.getRowCount("contacts");

		intialization();
		loginPage = new LoginPage();
		homePage = new HomePage();

		loginPage.login("adminuser541", "test123");
		TestUtil.switchToMainFrame();
		TestUtil.clickElementByJS(driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")), driver);

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String first_name = xl.getCellData("contacts", "firstname", rowNum);
			String last_name = xl.getCellData("contacts", "lastname", rowNum);
			String company_name = xl.getCellData("contacts", "company", rowNum);
			String email_id = xl.getCellData("contacts", "email", rowNum);

			driver.findElement(By.id("first_name")).clear();
			driver.findElement(By.id("first_name")).sendKeys(first_name);

			driver.findElement(By.id("surname")).clear();
			driver.findElement(By.id("surname")).sendKeys(last_name);

			driver.findElement(By.name("client_lookup")).clear();
			driver.findElement(By.name("client_lookup")).sendKeys(company_name);

			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(email_id);

			TestUtil.clickElementByJS(
					driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr/td/input[3]")), driver);

		}

	}

}
