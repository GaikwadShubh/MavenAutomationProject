package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.LaunchBrowser;
import pom.SwagLabLoginPage;
import utility.Parameterization;

public class SwagLabLoginTestParameterization
{	
	WebDriver driver;
	@BeforeMethod
	public void openChrome()
	{
		driver=LaunchBrowser.chrome("https://www.saucedemo.com/v1/");
	}
	

	@Test
	public void loginWithValidCredentials() throws EncryptedDocumentException, IOException
	{	
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		String username =Parameterization.readExcelData("SwagLab", 1, 1);
		swagLabLoginPage.enterUsername("username");
		String password =Parameterization.readExcelData("SwagLab", 2, 1);
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickLoginButton();
	}
	
	@Test
	public  void loginWithLockedUser() throws EncryptedDocumentException, IOException
	{
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		String username =Parameterization.readExcelData("SwagLab", 1, 2);
		swagLabLoginPage.enterUsername("username");
		String password =Parameterization.readExcelData("SwagLab", 2, 2);
		swagLabLoginPage.enterPassword("password");
		swagLabLoginPage.clickLoginButton();		
	}
	
	@Test
	public  void loginWithProblemUser() throws EncryptedDocumentException, IOException
	{
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		String username =Parameterization.readExcelData("SwagLab", 1, 3);
		swagLabLoginPage.enterUsername("username");
		String password =Parameterization.readExcelData("SwagLab", 2, 3);
		swagLabLoginPage.enterPassword("password");
		swagLabLoginPage.clickLoginButton();	
	}
	
	@Test
	public  void loginWithPerformanceGlitchUser() throws EncryptedDocumentException, IOException
	{	
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		String username =Parameterization.readExcelData("SwagLab", 1, 4);
		swagLabLoginPage.enterUsername("username");
		String password =Parameterization.readExcelData("SwagLab", 2, 4);
		swagLabLoginPage.enterPassword("password");
		swagLabLoginPage.clickLoginButton();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
