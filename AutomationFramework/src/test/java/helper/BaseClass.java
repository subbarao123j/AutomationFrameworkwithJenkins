package helper;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dataProviiderFactory.ConfigDataProvider;
import dataProviiderFactory.DataProviderFactory;

public class BaseClass {

	public WebDriver driver;

	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupReport() {
		
		System.out.println("LOG:Info- Before Suite Running-Setting up report");

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File("./Report/HRM_"+Utility.getTime()+".html"));

		report = new ExtentReports();
		report.attachReporter(reporter);
		
		System.out.println("LOG:Info- After Suite Running-Reports are ready to use");

	}
  
	@BeforeClass
	public void setupBrowser() {

		ConfigDataProvider config = new ConfigDataProvider();

		System.out.println("Log: INFO: Creatinng Browser Session");
		driver = BrowserFactory.startApplication(
				DataProviderFactory.getConfig().getBrowser(),
				DataProviderFactory.getConfig().getStagingURL());
		System.out.println("Log: INFO:  Browser Session Created");

	}

	@AfterMethod
	public void appendReport(ITestResult result) {
		
		System.out.println(result.getName());
		System.out.println(result.getTestName());
		
		System.out.println("LOG:ONFO- After method running- Generating Test report");

		int status = result.getStatus();
		
	

		if (status == ITestResult.SUCCESS) {

			logger.pass("Test Scenario passed");
			
			try {
				logger.pass("Test Passed" ,
						MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Not able to attach Screenshot" + e.getMessage());
			}

			System.out.println("Pass");

		} else if (status == ITestResult.FAILURE) {

			try {
				logger.fail("Test Failed" + result.getThrowable().getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Not able to attach Screenshot" + e.getMessage());
			}

			System.out.println("Fail");
		} else if (status == ITestResult.SKIP) {

			logger.skip("Test scenari skipped");
			System.out.println("skipped");

		}

		report.flush();
		
		System.out.println("LOG:INFO- After method ecuted-Test Result appended to report");

	}

	@AfterClass
	public void closeSession() {

		System.out.println("LOG: INFO : Closing Browser Session");
		driver.quit();
		System.out.println("LOG: INFO :  Browser Session closed");

	}
}
