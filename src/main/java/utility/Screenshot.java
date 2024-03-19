package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot
{
	public static void takeFullScreenshot(WebDriver driver,String fileName) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\91838\\OneDrive\\Desktop\\Arise\\Selenium\\screenshots"+fileName+".png");
		
		FileHandler.copy(source, destination);	
	}
	
	public static void takeElementScreenshot(WebDriver driver,String fileName,WebElement element) throws IOException
	{
		File source=((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\91838\\OneDrive\\Desktop\\Arise\\Selenium\\screenshots"+fileName+".png");
		
		FileHandler.copy(source, destination);
	}
}
