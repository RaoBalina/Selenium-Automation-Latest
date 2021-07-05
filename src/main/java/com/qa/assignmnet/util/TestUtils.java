package com.qa.assignmnet.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;


public class TestUtils {

	public static long PAGE_LOAD_WAIT = 20000;
	public static long IMPLICIT_WAIT = 2000;
	//public ExtentReports extent;
	//public ExtentTest extentTest;
	public static String TESTDATA_SHEET_PATH = "config/CreateArticle1.xlsx";;
	//public static String TESTDATA_SHEET_PATH = "C:/Users/bvaraprasad/Desktop/TestData.xlsx";;
	public static Workbook book;
	public static Sheet sheet;
	//public static WebDriver driver;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {

			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("LastRow:" + sheet.getLastRowNum() + "; Last Cell: " + sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k) != null ? sheet.getRow(i + 1).getCell(k).toString() : "";
			}
		}
		return data;

	}
	
	
public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		
		//return finalDestination.getAbsolutePath();
		
		return destination;
	}
//*********************************************support functions*****************************************************	




	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }

	

