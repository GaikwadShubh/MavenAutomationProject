package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser
{
	public static WebDriver chrome(String URL)
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\91838\\OneDrive\\Desktop\\Arise\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		return driver;
	}
}
