package com.freecrm.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.NewContactForm;
import com.freecrm.qa.util.TestUtil;

public class NewContactFormTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	NewContactForm ncf;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToMainFrame();
		homePage.clickOnNewContactLink();

	}

	// @Test
	// void ValidateAddNewContact() {
	// ncf = new NewContactForm();
	// ncf.saveNewContact("Aka", "sn");
	//
	// }

	@Test(dataProvider = "addcontacts_Data")
	void VerifyAddNewContact(Map mapdata) {
		ncf = new NewContactForm();
		System.out.println(mapdata.get("firstname"));
		System.out.println(mapdata.get("lastname"));
		System.out.println(mapdata.get("company"));
		System.out.println(mapdata.get("phone"));
		System.out.println(mapdata.get("homePhone"));
		System.out.println(mapdata.get("mobile"));
		System.out.println(mapdata.get("email"));

	}

	@DataProvider(name = "addcontacts_Data")
	public Object[][] newContactData() throws Exception {
		String filePath = "D:\\Aanand\\Project\\Selenium_Workspace_Tutorial"
				+ "\\DesignPOMDataDriven1\\src\\main\\java\\com\\freecrm\\qa\\testdata\\CRM_Contacts.xlsx";
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		wb.close();

		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowcount][1];

		// define map

		for (int i = 0; i < rowcount; i++) {
			Map<Object, Object> dataMap = new HashMap<Object, Object>();
			for (int j = 0; j < colcount; j++) {
				// read cell data and store in map
				dataMap.put(sheet.getRow(0), sheet.getRow(i + 1).getCell(j));
			}
			obj[i][0] = dataMap;
		}

		return obj;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
