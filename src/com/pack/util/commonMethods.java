package com.pack.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;


public class commonMethods {
	
	
	static WebDriver driver;
	
	public static WebDriver LoadBrowser(String URL) throws MalformedURLException {
		
		/*
		System.setProperty("webdriver.gecko.driver", "D:\\selenium-server-standalone-2.53.0\\geckodriver-v0.14.0-win64\\geckodriver.exe");

			Reporter.log("launching chrome browser!", true); 
			
			WebDriver driver = new ChromeDriver();
			
			
			driver.manage().deleteAllCookies();
			
			driver.manage().window().maximize();
			
			driver.get("https://wordpress.com/log-in");
			
			Reporter.log("Open Chrome browser and Load the " + "world press dot com" + " site",true);
			  return driver;
			  */
		

    System.setProperty("webdriver.chrome.driver", "D:\\selenium-server-standalone-2.53.0\\chromedriver_win32\\chromedriver.exe");    
		 DesiredCapabilities dr=null;
		 dr=DesiredCapabilities.chrome();
		 dr.setBrowserName("chrome");
		 dr.setPlatform(Platform.WINDOWS);
		 dr.setCapability("marionette", false);
		 RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.navigate().to(URL);
		  return driver;

	}
	 	  public static void Closebrowser(WebDriver driver) throws InterruptedException {
		  Thread.sleep(5000);
		  driver.quit();
		  Reporter.log("Browser Closed",true);
			 
		}
	 	  

public static WebDriver captureScreenshot(WebDriver driver,String screenshotName)
{
 
try 
{
TakesScreenshot ts=(TakesScreenshot)driver;
 
File source=ts.getScreenshotAs(OutputType.FILE);
 
FileUtils.copyFile(source, new File("./test-output/Screenshots/"+screenshotName+"_fail"+".png"));
 
Reporter.log("Screenshot taken",true);
return driver;
} 
catch (Exception e)
{
 
System.out.println("Exception while taking screenshot "+e.getMessage());
return driver;
} 
}



	  }
