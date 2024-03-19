package test;

import org.openqa.selenium.By;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.SwagLabLoginPage;
import utility.ReportsExtent;


public class SwagLabLoginTest4 extends BaseClass {
	
	public ExtentReports extentReports;
	public ExtentTest test;
	@BeforeTest
	public void reports()
	{
		 extentReports = ReportsExtent.generateReport();
	}
		
	@BeforeMethod
	public void openChrome()
	{
		 driver =LaunchBrowser.chrome("https://www.saucedemo.com/v1/");
	}
	
	@Test(priority=1)
	public  void loginWithValidCredentials()
	{	/*createTest method of ExtentReports will keep entry of our test in report and return ExtentTest class
	 	By using ExtentText class method we can log our report. All test info is stored in reference of ExtentTest Class*/
		test=extentReports.createTest("loginWithValidCredentials");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickLoginButton();		
	}
	
	@Test(priority=2)
	public  void loginWithLockedUser()
	{	
		test=extentReports.createTest("loginWithLockedUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername("locked_out_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickLoginButton();		
	}
	
	@Test(priority=3)
	public  void loginWithProblemUser()
	{	
		test=extentReports.createTest("loginWithProblemUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername("problem_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickLoginButton();	
	}
	
	@Test(priority=4)
	public void toFail()
	{	
		test=extentReports.createTest("toFail");
		driver.get("https://www.facebook.com/");
		driver.findElement(By.cssSelector("#email")).sendKeys("shubham");
		driver.findElement(By.cssSelector("#pass")).sendKeys("shubh@1234");
		driver.findElement(By.xpath("//button[@name='log']")).click();
	}
	
	@Test(dependsOnMethods="toFail",priority=5)
	public  void loginWithPerformanceGlitchUser()
	{	
		test=extentReports.createTest("loginWithPerformanceGlitchUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername("performance_glitch_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickLoginButton();
	}
	
	/*As like TESTNG ExtentReport not directly show which test is pass and which test is failed
	 * we have to configure it in our way. We have to methods of ExtentTest class*/
	
	 /*AfterMethod run after every test so we will get information about test 
	by using ITestResult class methods*/
	@AfterMethod
	public void closeBrowser(ITestResult result)
	{	
		/*log method of ExtentTest enter test result to report as pass/fail/skip with test name*/
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void publishReport()
	{
		extentReports.flush();
	}
	
	
	
	
}
