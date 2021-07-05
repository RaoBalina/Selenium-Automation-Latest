package com.qa.assignment.settings;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.assignment.Home.HomePOM;
import com.qa.assignment.article.ArticlePOM;
import com.qa.assignment.auth.SignInPOM;
import com.qa.assignmnet.util.TestBase;
import com.qa.assignmnet.util.TestUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class SettingsTest extends TestBase {

	private static HomePOM homePOM;
	private SignInPOM signInPOM;
	private SettingsPOM settingsPOM;
	String Expected = "Your Settings";
	public ExtentReports extent;
	public ExtentTest extentTest;

	public SettingsTest() {
		super();
		System.out.println("inside Constructor...");
	}
	/*@BeforeTest
	public void setExtent(){
		
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/IntellictaExtentReport-"+ new SimpleDateFormat("ddMMyyyy-HHmm").format(new Date())+ ".html", true);
		extent.addSystemInfo("Host Name", "Backbase");
		extent.addSystemInfo("User Name", "Varaprasadrao");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("Selenium Version", "3.2");
	}
	
	 @AfterTest
		public void endReport(){
			extent.flush();
			extent.close();
		}*/
	
	@BeforeMethod
	public void setup() {
		log = Logger.getLogger("loginPageTest");
		PropertyConfigurator.configure("log4j.properties");
		System.out.println("Before Method Calls...");
		intialization();
		log.debug("Intialization of Browser");
		homePOM = new HomePOM();


	}

	@Test(description = "TestSettings")
	public void TestSettings () throws InterruptedException {
		//extentTest = extent.startTest("TestSettings");
		signInPOM=homePOM.signinbutton();
		homePOM   = SignInPOM.signin();
		settingsPOM=HomePOM.settings();
		String actual=settingsPOM.TestText();
		Assert.assertEquals(actual, Expected);
	
	}
	/*@AfterMethod
	 public void tearDown(ITestResult result) throws IOException{
			
			if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			String screenshotPath =TestUtils.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
			extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
			   driver.quit();
			}*/
	
	@AfterMethod
	 public void tearDown() {
		driver.quit();
		
	}
	
	
	
}