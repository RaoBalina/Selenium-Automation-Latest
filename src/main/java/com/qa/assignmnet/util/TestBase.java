package com.qa.assignmnet.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.hamcrest.core.IsEqual.equalTo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.*;



public class TestBase {

	

	public static Properties prop;
	public static WebDriver driver;
	
	

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		TestBase.driver = driver;
	}

	public static Logger log;

	protected Logger logger;
	protected HashMap<String, WebElement> elementMap = new HashMap<>();
	public static Map<String, Object> prefs = new HashMap<String, Object>();

	public TestBase() {
		logger = Logger.getLogger(this.getClass());
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public WebElement getElement(String elementName) {
		return elementMap.get(elementName);
	}
	
	public  static  void intialization() {
		Logger logger = Logger.getLogger("TestBase");
		PropertyConfigurator.configure("log4j.properties");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		  capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		prefs.put("download.default_directory",System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		options.merge(capabilities);
		options.setExperimentalOption("prefs", prefs);
		String BrowserName = prop.getProperty("Browser");
		if (BrowserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver","C:/Users/bvaraprasad/Eclips-workspace5/IntellictaTest/lib/chromedriver/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","lib/chromedriver/chromedriver.exe");
			 driver= new ChromeDriver(options);
			logger.info("Launching chrome browser");
		} else if (BrowserName.equals("Firefox")) {
			System.setProperty("webDriver.gecko.driver", "C:/Users/bvaraprasad/Eclips-workspace5/IntellictaTest/lib/Geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("Launching Firefox browser");
			
		}

		log = Logger.getLogger(TestBase.class);
		driver.manage().window().maximize();
		log.debug("maximizing bwoser page");
		driver.manage().deleteAllCookies();
		logger.debug("Deletd all cookies");
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		logger.debug("Pageload Time out ON");
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Base_URL"));
		log.debug("Entering Application url");
		//return new ChromeDriver(options);
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		System.out.println("Screeshot");
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	 	
    	
}
