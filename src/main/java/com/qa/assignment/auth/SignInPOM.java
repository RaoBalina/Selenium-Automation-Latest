package com.qa.assignment.auth;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.assignment.Home.HomePOM;
import com.qa.assignment.settings.SettingsPOM;
import com.qa.assignmnet.util.TestBase;

public class SignInPOM extends TestBase {
	
	public static SettingsPOM settingsPOM;
	
	@FindBy(xpath="//input[@type='text']")
	private static WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private static WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private static WebElement sign;
	
	
	
	

	 public SignInPOM() {
		PageFactory.initElements(driver, this);
		
	}

	  public static HomePOM signin() throws InterruptedException{
		  username.sendKeys("vara5@gmail.com");
		  password.sendKeys("User@3322");
		  sign.click();
		 Thread.sleep(15000);
		  
		  return  new HomePOM();
	  }
	 
	 
	 
	 
	 
	
	
}

	
