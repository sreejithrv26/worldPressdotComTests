/**
 * 
 */
package com.pack.page;
import com.pack.util.commonMethods;
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
 * This Page is used to store all the elements and methods pertain to login page.
 *
 */
public class LoginPage extends commonMethods{
	protected WebDriver driver;
    

	@FindBy(how=How.XPATH,using="//*[@id='usernameOrEmail']")
	@CacheLookup
	WebElement user_Name;
	
	@FindBy(how=How.XPATH,using="//*[@id='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//*[@id='primary']/div/main/div/div[1]/div/form/div/div[2]/label/input")
	@CacheLookup
	WebElement rememberMe;
	
	@FindBy(how=How.XPATH,using="//button[@class='button form-button is-primary']")
	@CacheLookup
	WebElement submit;
	
	@FindBy(how=How.XPATH,using="//*[@id='primary']/div/main/div/div[2]/a[1]")
	@CacheLookup
	WebElement forgotPassword;
		

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	public WebDriver loginInTOTheSite(String UserName, String Password){
		
		
		
		user_Name.sendKeys(UserName);
		Reporter.log("The user name is keyed in!", true);
		
		password.sendKeys(Password);
		Reporter.log("The password is keyed in!", true);
		
		rememberMe.click();
		Reporter.log("The remember me check-bob is selected!", true);
		
		submit.click();
		Reporter.log("Submitted link is clicked!", true);
		
		
		return driver;
		
	}



}
