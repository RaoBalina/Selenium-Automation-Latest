package com.qa.assignment.profile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.assignment.Home.HomePOM;
import com.qa.assignmnet.util.TestBase;

public class ProfilePOM extends TestBase {

	@FindBy(xpath="//a[@class='btn btn-sm btn-outline-secondary action-btn']")
	private WebElement profilesetting;
	@FindBy(xpath="//a[contains(text(),'vara5')]")
	private static WebElement user;
	
	@FindBy(xpath="//h4[contains(text(),'vara5')]")
	private WebElement vara5;
	
	@FindBy(xpath="//a[contains(text(),'My Posts')]")
	  private static  WebElement mypost;
	
	public ProfilePOM() {
		PageFactory.initElements(driver, this);
	
	
	}
	
	public String profilesetting(){
	          return profilesetting.getText();
	       
	}
	
	
	     
	   public static ProfilePOM Listofarticles() throws InterruptedException{			 
		  
			List<WebElement> listofarticles = driver.findElements(By.xpath("//a//h1"));	
			List<String> articleList = new ArrayList<String>();
			for(WebElement article: listofarticles)
			{
				articleList.add(article.getText());
				System.out.println(article.getText());
			}			    
			
		   return new 	ProfilePOM();
			
		}
	   
	   
	   
                public String  verifytext(){
                	 return vara5.getText();
                	}
                
                
            	public static ProfilePOM Pagenation(){
            		List<WebElement> pagination =driver.findElements(By.xpath("//a[@class='page-link']")); 
            			System.out.println(pagination);
            		// checkif pagination link exists 
            			if(pagination .size()>0){ 
            			System.out.println("pagination exists"); 
            			// click on pagination link 
            			for(int i=0; i<pagination .size(); i++){ 
            			pagination.get(i).click(); 
            			} 
            			} else { 
            			System.out.println("pagination not exists"); 
            			}
            			            return new ProfilePOM();
            		}
                
                
                
                
                
                
                
                
                
}


