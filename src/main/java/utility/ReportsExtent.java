package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsExtent 
{
	public static ExtentReports generateReport()
	{	
		//ExtentSparkReporter this class is used to generate report
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("ExtentReport.html");
		
		//ExtentReports will collect the test result data and store in reference variable and 
		//pass this data through attachReporter method to ExtentSparkReporter to generate report.
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Test Type:","Regression");
		extentReports.setSystemInfo("Created By:","Shubham Gaikwad");
		
		return extentReports;
				
	}
}
