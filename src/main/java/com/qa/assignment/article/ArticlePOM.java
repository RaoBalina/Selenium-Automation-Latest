package com.qa.assignment.article;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.assignment.Home.HomePOM;
import com.qa.assignmnet.util.TestBase;

public class ArticlePOM extends TestBase {
	@FindBy(xpath="//input[@class='form-control form-control-lg ng-untouched ng-pristine ng-valid']")
	private static WebElement Articletitle;
	@FindBy(xpath="//input[@formcontrolname='description']")
	private static WebElement Articlabout;
	@FindBy(xpath="//textarea[@class='form-control ng-untouched ng-pristine ng-valid']")
	private static WebElement Textarea;
	@FindBy(xpath="//input[@placeholder='Enter tags']")
	private static WebElement EnterTags;
	
	@FindBy(xpath="//button[@class='btn btn-lg pull-xs-right btn-primary']")
	private static WebElement publishbutton;
	
	
	@FindBy(xpath="//div[@class='article-actions']//app-article-meta//div[@class='article-meta']//span//a[@class='btn btn-sm btn-outline-secondary'][contains(text(),'Edit Article')]")
	private static WebElement editarticle;;
	
	@FindBy(xpath="//div[@class='container']//app-article-meta//div[@class='article-meta']//span//button[@class='btn btn-sm btn-outline-danger'][contains(text(),'Delete Article')]")
	private WebElement Deletearticle;
	@FindBy(xpath="//textarea[@placeholder='Write a comment...']")
	private WebElement  commentarea;
	@FindBy(xpath="//button[@class='btn btn-sm btn-primary']")
	private WebElement  postcomment;
	
	@FindBy(xpath="//span[@class='mod-options']//i[@class='ion-trash-a']")
	private WebElement  deletecomment;
	
	
	public ArticlePOM() {
		PageFactory.initElements(driver, this);
	
	
	}
	
	
	
	public static void Editarticle(String articletitle,String articleabout,String textarea,String entertags){
		editarticle.click();
		Articletitle.clear();
		Articletitle.sendKeys(articletitle);
		Articlabout.clear();
		Articlabout.sendKeys(articleabout);
		Textarea.clear();
		Textarea.sendKeys(textarea);
		EnterTags.clear();
		EnterTags.sendKeys(entertags);
		publishbutton.click();
		
		
	}
        public HomePOM deletearticle(){
        	
        	Deletearticle.click();
        	 
        	return new HomePOM();
        	
        }

	      public ArticlePOM commentarea() throws InterruptedException{
	    	  commentarea.sendKeys("Success");
	    	  Thread.sleep(1500);
	    	  postcomment.click();
	    	  Thread.sleep(1000);
	    	  deletecomment.click();
	    	  return new ArticlePOM();
	    	  
	      }
	

}
