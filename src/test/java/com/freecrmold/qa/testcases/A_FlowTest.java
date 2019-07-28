package com.freecrmold.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class A_FlowTest {

	public static void main(String[] args) throws Exception {

		cellData();

	}

	public static Object[][] cellData() throws Exception {
		String filePath = "D:\\Aanand\\Project\\Selenium_Workspace_Tutorial"
				+ "\\DesignPOMDataDriven1\\src\\main\\java\\com\\freecrm\\qa\\testdata\\CRM_Contacts.xlsx";
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowcount][0];

		// define map

		Map<Object, Object> hm = new HashMap<Object, Object>();

		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				// read cell data and store in map
				hm.put(sheet.getRow(i), sheet.getRow(i + 1).getCell(j));
			}

		}
		wb.close();
		return obj;

	}
}
