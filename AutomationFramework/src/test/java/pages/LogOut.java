package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogOut {

	WebDriver driver;

	public LogOut(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
	WebElement WelcomeText;
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	public void clickLogout() {

		System.out.println("Log Info logged out success");

		WelcomeText.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
					}

		logout.click();

	}

}
