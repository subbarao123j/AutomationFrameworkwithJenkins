package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dataProviiderFactory.ExcelDataProvider;
import helper.BaseClass;
import pages.LogOut;
import pages.Login;

public class LoginTest extends BaseClass {
	
	Login login;
	LogOut logout;
	@Test(description = "", priority = 1)
	public void loginToHRM() {

		 login = PageFactory.initElements(driver, Login.class);

		 logout = PageFactory.initElements(driver, LogOut.class);

		logger = report.createTest("Login Test for OrangeHRM");

		login.validateHomePage();

		logger.pass("Home page validated");

		login.enterUserName();
		logger.info("User name entered");
		
		login.enterPassword();
		logger.info("Pasword entered");
		
		login.clickLoginButton();
		logger.info("Login entered");

		logout.clickLogout();
		
		logger.pass("User is able to logout");

	}
	
	
}
