package helper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import dataProviiderFactory.ConfigDataProvider;


public class BaseClass {
	
	public WebDriver driver;
	
	
	@BeforeClass
	public void setupBrowser() {
		
		
		ConfigDataProvider config = new ConfigDataProvider();
	
		System.out.println("Log: INFO: Creatinng Browser Session");
	  driver = BrowserFactory.startApplication(config.getBrowser(),config.getStagingURL());
	  System.out.println("Log: INFO:  Browser Session Created");

	}
	@AfterClass
	public void closeSession() {
		
		System.out.println("LOG: INFO : Closing Browser Session");
		driver.quit();
		System.out.println("LOG: INFO :  Browser Session closed");
		
		
	}
}
