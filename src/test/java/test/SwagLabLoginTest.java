package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.LaunchBrowser;
import pom.SwagLabLoginPage;

public class SwagLabLoginTest
{	
	WebDriver driver;
	@BeforeMethod
	public void openChrome()
	{
		driver=LaunchBrowser.chrome("https://www.saucedemo.com/v1/");
	}
	
	@Test
	public void loginWithValidCredentials()
	{
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickLoginButton();
		
		boolean status=swagLabLoginPage.isLogoDisplayed();
		Assert.assertFalse(status);
		System.out.println("test passed");
		
		
	}
	
	@Test
	public  void loginWithLockedUser()
	{
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername("locked_out_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickLoginButton();		
	}
	
	@Test
	public  void loginWithProblemUser()
	{
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername("problem_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickLoginButton();	
	}
	
	@Test
	public  void loginWithPerformanceGlitchUser()
	{	
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername("performance_glitch_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickLoginButton();
	}
	
	@Test
	public void gitDemo()
	{
		System.out.println("Git demo trial");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
