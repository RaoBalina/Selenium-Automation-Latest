package com.qa.assignment.article;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.assignmnet.util.TestBase;

public class EditorPOM extends TestBase {
	
	
	@FindBy(xpath="//input[@class='form-control form-control-lg ng-untouched ng-pristine ng-valid']")
	private  WebElement Articletitle;
	@FindBy(xpath="//input[@formcontrolname='description']")
	private  WebElement Articlabout;
	@FindBy(xpath="//textarea[@class='form-control ng-untouched ng-pristine ng-valid']")
	private WebElement Textarea;
	@FindBy(xpath="//input[@placeholder='Enter tags']")
	private  WebElement EnterTags;
	
	@FindBy(xpath="//button[@class='btn btn-lg pull-xs-right btn-primary']")
	private  WebElement publishbutton;
	
	
	
	
	public EditorPOM() {
		PageFactory.initElements(driver, this);
	
	
	}
	
	public  ArticlePOM createarticle(String articletitle,String articleabout,String textarea,String entertags) throws InterruptedException{
		
		Articletitle.sendKeys(articletitle);
		Articlabout.sendKeys(articleabout);
		Textarea.sendKeys(textarea);
		EnterTags.sendKeys(entertags);
		publishbutton.click();
	    
		Thread.sleep(15000);
		   return new ArticlePOM();
		
	}
}