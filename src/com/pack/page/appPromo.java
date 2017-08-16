/**
 * 
 */
package com.pack.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import junit.framework.Assert;

/**
 * @author Sreejith_Vikram
 *
 */
public class appPromo {
	
protected WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//*[@id='masterbar']/ul/li[2]/a")
	@CacheLookup
	WebElement SignInLink;
	
	public appPromo(WebDriver driver) {
		this.driver=driver;
		
	}
	
		
	public WebDriver clickAppPromoSignInLink() throws InterruptedException{
		Thread.sleep(10000);
		SignInLink.click();
		Reporter.log("My App Page SignIn link is clicked!", true);
		return driver;
		
	}
	

}
