package com.pack.util;

import com.pack.test.worldPressdotComTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class testNGListener extends TestListenerAdapter {
    String Seperator=System.getProperty("file.separator");
    private static WebDriver driver;
    @Override
    public void onTestFailure(ITestResult result) {
  
    	System.out.println("inside onTestFailure");
        Reporter.setCurrentTestResult(result);
        String sFileName=result.getMethod().getMethodName();
        System.out.println("sFileName = "+sFileName);
        driver= worldPressdotComTests.gerDriverDetails(sFileName);
        System.out.println("driver_failure = "+driver);
        commonMethods.captureScreenshot(driver, sFileName);
        String imagePathInHost="C:/Users/Sreejith_Vikram/workspace/worldPressDotCom/test-output/Screenshots/"+sFileName+"_fail.jpg";
        Reporter.log("<a href=" + imagePathInHost + "> <img width='100' height='100' src=" + imagePathInHost + "> </a>");
        Reporter.setCurrentTestResult(null);
		commonMethods.Quitebrowser(driver);
		

    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
    	System.out.println("inside onTestSuccess");
        Reporter.setCurrentTestResult(result);
        String sFileName=result.getMethod().getMethodName();
        System.out.println("sFileName = "+sFileName);
        driver= worldPressdotComTests.gerDriverDetails(sFileName);
        System.out.println("driver_success = "+driver);
        Reporter.setCurrentTestResult(null);
		commonMethods.Quitebrowser(driver);
		
		}
        
        

   
    
   
    
}