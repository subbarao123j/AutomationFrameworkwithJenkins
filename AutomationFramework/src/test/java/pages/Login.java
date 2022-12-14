package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import dataProviiderFactory.DataProviderFactory;
import dataProviiderFactory.ExcelDataProvider;
import helper.Utility;

public class Login {

	WebDriver driver;

	public Login(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;

	public void validateHomePage() {
		
		Utility.validatingContainsTitle(driver, "OrangeHRM");

		//Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Home page doesnot appear");

	}

	public void enterUserName(String uname) {

		System.out.println("Log Info usernaame entered");

		username.sendKeys(uname);

	}

	public void enterPassword(String pass) {

		System.out.println("Log Info Password entered");

		password.sendKeys(pass);

	}

	public void enterUserName() {

		System.out.println("Log Info usernaame entered");

		username.sendKeys(DataProviderFactory.getExcel().getCellData("Login", 1, 0));

	}

	public void enterPassword() {

		System.out.println("Log Info Password entered");

		password.sendKeys(DataProviderFactory.getExcel().getCellData("Login", 1, 1));

	}

	public void clickLoginButton() {

		System.out.println("Log Info login entered");

		login.click();

	}

}
