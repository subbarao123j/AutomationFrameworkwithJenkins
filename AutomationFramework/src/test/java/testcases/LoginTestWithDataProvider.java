package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviiderFactory.DataProviderFactory;
import dataProviiderFactory.ExcelDataProvider;
import helper.BaseClass;
import pages.LogOut;
import pages.Login;

public class LoginTestWithDataProvider extends BaseClass {

	Login login;
	LogOut logout;

	@Test(dataProvider = "LoginData")
	public void loginToHRM(String uname, String pass) {

		login = PageFactory.initElements(driver, Login.class);

		logout = PageFactory.initElements(driver, LogOut.class);

		logger = report.createTest("Login Test for OrangeHRM");

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

	@DataProvider(name = "LoginData")
	public Object[][] getDataFromSources() {

		System.out.println("LOG: INFO Running Data provider first to generate the data");

		int rows = DataProviderFactory.getExcel().getRows("Login");

		System.out.println("Total rows in Excel" + rows);

		Object[][] arr = new Object[rows][2];

		for (int i = 1; i < rows; i++) {
			arr[i][0] = DataProviderFactory.getExcel().getCellData("Login", i, 0);
			arr[i][1] = DataProviderFactory.getExcel().getCellData("Login", i, 1);
		}

		System.out.println("LOG:Info Data provider is ready for usage");

		return arr;

	}

}
