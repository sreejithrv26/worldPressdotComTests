package com.pack.util;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.net.URL;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.jasper.tagplugins.jstl.core.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;


public class commonMethods {
	
	static ATUTestRecorder recorder;
	static ScreenRecorder  screenRecorder;
	//private static WebDriver driver;
	protected static ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	 public static WebDriver onTestStart(String URL) throws Exception{  
	    	
	    	threadDriver = new ThreadLocal<RemoteWebDriver>();
	        System.setProperty("webdriver.chrome.driver", "D:\\selenium-server-standalone-2.53.0\\chromedriver_win32\\chromedriver.exe");    
			 DesiredCapabilities dr=null;
			 dr=DesiredCapabilities.chrome();
			 dr.setBrowserName("chrome");
			 dr.setPlatform(Platform.WINDOWS);
			 dr.setCapability("marionette", false);
			 RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
			 threadDriver.set(driver);
			 getDriver().manage().window().maximize();
			 getDriver().manage().deleteAllCookies();
			 getDriver().navigate().to(URL);
			 return getDriver();
	    }
	    
	    public static WebDriver getDriver() {
	        return threadDriver.get();
	    }
	 

		  public static void Quitebrowser(WebDriver driver){
			  System.out.println("driver_Quit = " + driver);
			  Reporter.log("Browser Closed",true);
			  driver.quit();
			  
			}
		 	  

public static WebDriver captureScreenshot(WebDriver driver,String screenshotName)
{
 
try 
{
TakesScreenshot ts=(TakesScreenshot)getDriver();
 
File source=ts.getScreenshotAs(OutputType.FILE);
 
FileUtils.copyFile(source, new File("./test-output/Screenshots/"+screenshotName+"_fail"+".jpg"));
logMessage(getDriver(),"Screenshot taken");
return getDriver();
} 
catch (Exception e)
{

System.out.println("Exception while taking screenshot "+e.getMessage());
return getDriver();
} 
}


public static WebDriver highLightElement(WebDriver driver, WebElement element) throws InterruptedException
{
try 
	{
Thread.sleep(1000);
JavascriptExecutor js=(JavascriptExecutor)getDriver(); 
js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
Thread.sleep(1000);
js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
Thread.sleep(1000);
return getDriver();
} 
catch (InterruptedException e) {
 
System.out.println(e.getMessage());
return getDriver();
} 
	  }

public static WebDriver logMessage(WebDriver driver, String message) throws InterruptedException {
	
	String timeStamp = new SimpleDateFormat("dd-MM-YYY HH:mm:ss").format(Calendar.getInstance().getTime());
	Reporter.log("<li><b>"+"["+timeStamp +"]"+" "+message+"</b></li>", true);
	return getDriver();
}



}