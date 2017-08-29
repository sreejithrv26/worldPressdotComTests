/**
 * 
 */
package com.pack.page;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.pack.util.commonMethods;
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
 * This Page is used to store all the elements and methods pertain to login page.
 *
 */
public class LoginPage extends commonMethods{
	private WebDriver driver;
    

	@FindBy(how=How.XPATH,using="//*[@id='usernameOrEmail']")
	@CacheLookup
	private WebElement user_Name;
	
	@FindBy(how=How.XPATH,using="//*[@id='password']")
	@CacheLookup
	private WebElement password;
	
	@FindBy(how=How.XPATH,using="//*[@id='primary']/div/main/div/div[1]/div/form/div/div[2]/label/input")
	@CacheLookup
	private WebElement rememberMe;
	
	@FindBy(how=How.XPATH,using="//button[@class='button form-button is-primary']")
	@CacheLookup
	private WebElement submit;
	
	@FindBy(how=How.XPATH,using="//*[@id='primary']/div/main/div/div[2]/a[1]")
	@CacheLookup
	private WebElement forgotPassword;
		

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	public WebDriver loginInTOTheSite(String UserName, String Password) throws InterruptedException{
		
		
		commonMethods.highLightElement(driver, user_Name);
		user_Name.sendKeys(UserName);
		//Reporter.log("The user name is keyed in!", true);
		commonMethods.logMessage(driver,"The user name is keyed in!");
		
		commonMethods.highLightElement(driver, password);
		password.sendKeys(Password);
		//Reporter.log("The password is keyed in!", true);
		commonMethods.logMessage(driver,"The password is keyed in!");
		
		commonMethods.highLightElement(driver, rememberMe);
		rememberMe.click();
		//Reporter.log("The remember me check-box is selected!", true);
		commonMethods.logMessage(driver,"The remember me check-box is selected!");
		
		commonMethods.highLightElement(driver, submit);
		submit.click();
		//Reporter.log("Submitted link is clicked!", true);
		commonMethods.logMessage(driver,"Submitted link is clicked!");
		
		return driver;
		
	}



}
