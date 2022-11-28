package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dataProviiderFactory.ExcelDataProvider;
import helper.BaseClass;
import pages.LogOut;
import pages.Login;

public class LoginTest extends BaseClass {
	@Test
	public void loginToHRM() {

		Login login = PageFactory.initElements(driver, Login.class);

		LogOut logout = PageFactory.initElements(driver, LogOut.class);

		login.validateHomePage();

		login.enterUserName();
		login.enterPassword();
		login.clickLoginButton();

		logout.clickLogout();

	}

}
