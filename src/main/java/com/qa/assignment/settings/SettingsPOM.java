package com.qa.assignment.settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.assignmnet.util.TestBase;

public class SettingsPOM extends TestBase {

	
	
	@FindBy(xpath="//h1[@class='text-xs-center']")
	private static WebElement textsettings;
	
	public SettingsPOM() {
		PageFactory.initElements(driver, this);
		
		elementMap.put("textsettings", textsettings);
	
	}
	
	
	public String TestText(){
		 return textsettings.getText();		
	}
	
	

}
