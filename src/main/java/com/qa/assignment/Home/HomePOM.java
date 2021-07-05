package com.qa.assignment.Home;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.assignment.article.EditorPOM;
import com.qa.assignment.auth.SignInPOM;
import com.qa.assignment.profile.ProfilePOM;
import com.qa.assignment.settings.SettingsPOM;
import com.qa.assignmnet.util.TestBase;

public class HomePOM extends TestBase {
	
	
	@FindBy(xpath="//div[@class='tag-list']")
	 private WebElement Taglist;
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	private   WebElement signin;
	@FindBy(xpath="//*[contains(text(),'Settings')]")
	private static WebElement settings;
	
	@FindBy(xpath="//a[contains(text(),'New Article')]")
	private static WebElement NewArticle;
	
	@FindBy(xpath="//a[contains(text(),'vara5')]")
	private WebElement user;
	
	@FindBy(xpath="//a[contains(text(),'Global Feed')]")
	private static   WebElement globalfeed;
	
	public HomePOM() {
		PageFactory.initElements(driver, this);
	
	
	}
	
	
	public ProfilePOM vara5(){
		user.click();
		return new ProfilePOM();
	}
	/*public  HomePOM  listofTags(){
	List<WebElement> spans = driver.findElements(By.xpath("//*[@class='tag-list']"));
	System.out.println(spans);
	int[] numbers = new int[spans.size()];
	for (int i = 0; i < spans.size(); i++)
	{
	    numbers[i] = Integer.parseInt(spans.get(i).getText());
	    System.out.println(numbers[i]);
	}
	       return new HomePOM();
	
	}*/
	
	public ProfilePOM Baseuser(){
		user.click();
			return new ProfilePOM();
	}
	
	public static HomePOM Listoftags(){
		
		List<WebElement> myElement = driver.findElements(By.xpath("//div//a[@class='tag-default tag-pill']"));
		List<String> myList = new ArrayList<String>();
		for(WebElement ele:myElement)
		{
		    myList.add(ele.getText());
		    System.out.println(ele.getText());
		}
		String[] myArray = myList.toArray(new String[0]);
		System.out.println(myArray);
		 return new HomePOM();
	}
	

	
	
	
	   public   SignInPOM  signinbutton (){
		  
		   signin.click();
		   
		     return new SignInPOM();
		   	   
	   }
	
	   public static SettingsPOM settings (){
			
			settings.click();
			 return new SettingsPOM();
		}
		
	   public   EditorPOM  NewArticlebutton (){
			  
		   NewArticle.click();
		   
		     return new EditorPOM();
		   	   
	   }
	
	 
	 
	
	   public static HomePOM Listofarticles() throws InterruptedException{			 
			   globalfeed.click();			   
				List<WebElement> listofarticles = driver.findElements(By.xpath("//a//h1"));	
				List<String> articleList = new ArrayList<String>();
				for(WebElement article: listofarticles)
				{
					articleList.add(article.getText());
					System.out.println(article.getText());
				}			    
				
			   return new 	HomePOM();
				
			}

	
}
