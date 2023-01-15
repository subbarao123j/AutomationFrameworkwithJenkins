package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.LogOut;
import pages.Login;




public class LoginFromJenkins extends BaseClass {
	
	
	Login login;
	LogOut logout;
	
	@Parameters({"username" , "password"})
	@Test(description = "", priority = 1)
	public void loginToHRM(String uname, String pass) {

		 login = PageFactory.initElements(driver, Login.class);

		 logout = PageFactory.initElements(driver, LogOut.class);

		logger = report.createTest("Login Test for OrangeHRM(Demo)");

		login.validateHomePage();

		logger.pass("Home page validated");

		login.enterUserName(uname);
		logger.info("User name entered");
		
		login.enterPassword(pass);
		logger.info("Pasword entered");
		
		login.clickLoginButton();
		logger.info("Login entered");

		logout.clickLogout();
		
		logger.pass("User is able to logout");

	}
	
	
}
