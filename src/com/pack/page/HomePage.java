package com.pack.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.pack.util.commonMethods;

import junit.framework.Assert;

/**
 * @author Sreejith_Vikram
 * 
 * This Page is used to store all the elements and methods pertain to login page.
 *
 */

public class HomePage extends commonMethods{
	
	private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//span[@class='masterbar__item-content']")
	@CacheLookup
	private List<WebElement> allHeaderElements;
	
	@FindBy(how=How.XPATH,using="//img[@class='gravatar']")
	@CacheLookup
	private List<WebElement> myAccountLine;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}

	public WebDriver clickMyAccountLink() throws InterruptedException{
		Thread.sleep(10000);
		commonMethods.highLightElement(driver, myAccountLine.get(0));
		myAccountLine.get(0).click();
		commonMethods.logMessage(driver,"MyAccount link is clicked!");
		//Reporter.log("MyAccount link is clicked!", true);
		return driver;
		
	}
	
	}


