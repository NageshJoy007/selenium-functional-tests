package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class TestDataUtil {
	
	
	

	@DataProvider(name = "loginTest")
	public static Object[][] loginTestData() throws Exception {
		Object[][] retObjArr = readData(
				System.getProperty("user.dir") + "//src//test//resources//TestData//Data.xlsx", "loginTest");
		return (retObjArr);
	}
	
	@DataProvider(name = "productSearchTest")
	public static Object[][] productSearchTestData() throws Exception {
		Object[][] retObjArr = readData(
				System.getProperty("user.dir") + "//src//test//resources//TestData//Data.xlsx", "productSearchTest");
		return (retObjArr);
	}
	
	
	public static String[][] readData(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(0);

		int rowCount = sheet.getLastRowNum() + 1;
		int columnCount = row.getLastCellNum();

		String[][] arrayExcelData = new String[rowCount - 1][columnCount];
		System.out.println("Total_TestDataSets: " + arrayExcelData.length);
		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < columnCount; j++) {
				arrayExcelData[i - 1][j] = sheet.getRow(i).getCell(j).toString();
				System.out.println(sheet.getRow(i).getCell(j).toString());

			}

		}
		return arrayExcelData;

	}

}
