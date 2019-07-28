package com.freecrmold.qa.util;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freecrmold.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICITLY_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "D:\\Aanand\\Project\\Selenium_Workspace_Tutorial\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\CRM_Contacts.xlsx";

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void waitFor(WebDriver driver, WebElement locator, int timeOut) {
		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeSelected(locator));
	}

	public static void clickOn(WebDriver driver, WebElement locator, int timeOut) {
		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

	public static void switchToMainFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void switchToLeftFrame() {
		driver.switchTo().frame("leftpanel");
	}

	public static HashMap<String, String> loginData() {

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("user", "username@password");
		hm.put("admin", "adminuser541@test123");
		hm.put("emp1", "empuser681@test123");
		hm.put("emp2", "empuser682@test123");
		hm.put("emp3", "empuser683@test123");

		return hm;

	}

	public static void loginData(String user) {

		HashMap<String, String> userList = new HashMap<String, String>();
		userList.put("admin", "adminuser541@test123");
		userList.put("emp1", "empuser681@test123");
		userList.put("emp2", "empuser682@test123");
		userList.put("emp3", "empuser683@test123");

		for (Entry<String, String> m : userList.entrySet()) {
			String key = m.getKey();
			if (key == user) {
				String[] userCredential = m.getValue().split("@");
				String username = userCredential[0];
				driver.findElement(By.name("username")).sendKeys(username);
				// Enter password directly in sendKeys() without storing it in variable
				driver.findElement(By.name("password")).sendKeys(userCredential[1]);
				break;
			} else {
				System.out.println("Please pass the exact 'user' as put in HashMap userList");
			}
		}
		clickElementByJS(driver.findElement(By.xpath("//input[contains(@class,'btn btn-small')]")), driver);

	}

}
