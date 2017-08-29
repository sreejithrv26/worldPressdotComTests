package com.pack.test;

import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import com.pack.page.LoginPage;
import org.testng.annotations.Test;
import com.pack.page.*;
import com.pack.util.*;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
public class worldPressdotComTests {
	
	private static final ITestContext ITestContext = null;
	static String Password;
	static String UserName;
	static String URL;
	static WebDriver drive_Test_Login;
	static WebDriver drive_Test_Logout;
	static ATUTestRecorder recorder;
	private  static WebDriver driver;
	 private static HashMap<String, WebDriver> driverObjMap=new HashMap<String, WebDriver>();
  @BeforeClass
  public static void beforeClass() throws IOException {
	FileInputStream dataFile = new FileInputStream(
				new File(
						"C:\\Users\\Sreejith_Vikram\\workspace\\worldPressDotCom\\test-Data\\testDatFile.xlsx"));
  XSSFWorkbook xlsx_wbk = new XSSFWorkbook(dataFile); // for .xlsx file
 // HSSFWorkbook xls_wbk = new HSSFWorkbook(dataFile); //for xls files
   XSSFSheet xlsx_firstsheet = xlsx_wbk.getSheetAt(0);
   XSSFSheet xlsx_secondsheet = xlsx_wbk.getSheetAt(1);
   UserName = xlsx_firstsheet.getRow(1).getCell(0).getStringCellValue();
   Password = xlsx_firstsheet.getRow(1).getCell(1).getStringCellValue();  
   URL = xlsx_secondsheet.getRow(0).getCell(1).getStringCellValue();
   
  }

  @BeforeMethod
  public void beforeTest() throws Exception{
	  
	  driver = commonMethods.onTestStart(URL);
	  System.out.println("driver in before method" + driver);
  }
  
  public static WebDriver gerDriverDetails(String methodName){
	 if(methodName.equalsIgnoreCase("LoginTest_WorldPress")){
		 return drive_Test_Login;}
		 else{
			 return drive_Test_Logout;
		 }
	 
	  
	  
  }
  

  
  @Test(groups={"WorldPressdotCom_LoginTest"}, description = "This Test is to Validate login freature in world press dot com")
  public void LoginTest_WorldPress() throws InterruptedException, MalformedURLException, ATUTestRecorderException {
	  
	  System.out.println("LoginTest_driver = "+ driver);
	  drive_Test_Login=driver;
	  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	  loginPage.loginInTOTheSite(UserName, Password);
	  
  }
 
  @Test(groups={"WorldPressdotCom_LogoutTest"}, description = "This Test is to Validate logout freature in world press dot com")
  public void LogoutTest_WorldPress() throws InterruptedException, MalformedURLException, ATUTestRecorderException {
	  System.out.println("LogoutTest_driver = "+ driver);
	  drive_Test_Logout=driver;
	  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	  loginPage.loginInTOTheSite(UserName, Password);
	  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	  homePage.clickMyAccountLink();
	  myProfilePage myprofilepage = PageFactory.initElements(driver, myProfilePage.class);
	  myprofilepage.clickMyAccountLogoutLink();
	  appPromo appPromo = PageFactory.initElements(driver, appPromo.class);
	  appPromo.clickAppPromoSignInLink();

  }
  
  

}
