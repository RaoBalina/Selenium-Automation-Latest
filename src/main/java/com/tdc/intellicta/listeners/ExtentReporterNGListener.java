package com.tdc.intellicta.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReporterNGListener implements IReporter {
	
	private ExtentReports extent;
	public ExtentTest extentTest;
	public WebDriver driver;

	//

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator + "Reports" + File.separator
				+ "IntellictaTestReport-" + new SimpleDateFormat("ddMMyyyy-HHmm").format(new Date()) + ".html", true);
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				String testName;
				// Get method description; if not available use method name
				if(result.getMethod().getDescription() != null) {
					testName = result.getMethod().getDescription();
				} else {
					testName = result.getMethod().getMethodName();
				}
				
				// Append test message if available
				if (result.getParameters().length > 1) {
					testName = testName.concat("-" + result.getParameters()[result.getParameters().length - 1]);
				}
				System.out.println(result.getMethod().getMethodName());
				test = extent.startTest(testName);
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);
				test.log(status, "Test " + status.toString().toLowerCase() + "ed" + " :: Test Data "
						+ Arrays.toString(result.getParameters()));
				if (result.getThrowable() != null) {
					// TODO Capture screenshot
					
					
				}
				extent.endTest(test);
			}

		}

	}

	private Date getTime(long millis) {
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(millis);
		return calender.getTime();

	}
	
	

}
