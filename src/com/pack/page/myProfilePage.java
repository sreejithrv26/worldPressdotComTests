/**
 * 
 */
package com.pack.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;
import com.pack.util.commonMethods;
import junit.framework.Assert;

/**
 * @author Sreejith_Vikram
 *
 */
public class myProfilePage {
	
private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//button[@class='button me-sidebar__signout-button is-compact']")
	@CacheLookup
	private WebElement SignOut;
	
	public myProfilePage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	
	public WebDriver clickMyAccountLogoutLink() throws InterruptedException{
		Thread.sleep(10000);
		commonMethods.highLightElement(driver, SignOut);
		SignOut.click();
		commonMethods.logMessage(driver,"MyAccount Logout link is clicked!");
		//Reporter.log("MyAccount Logout link is clicked!", true);
		return driver;
		
	}
	
	
	

}
