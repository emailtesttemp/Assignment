package automation.tests;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common.utilities.ConfigFileReader;
import page.objects.FbHomePage;
import page.objects.FbLoginPage;

public class Assignment1 extends Base {

	ConfigFileReader configFileReader;
	FbLoginPage loginPage;
	FbHomePage homePage;

	@Test
	public void facebookAssignment() throws InterruptedException, IOException {

		// Initialize Page Objects
		configFileReader = new ConfigFileReader();
		loginPage = new FbLoginPage(driver);
		homePage = new FbHomePage(driver);

		// Launch URL
		driver.get("https://www.facebook.com/");
		
		new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();

		// Provide Credentials & Login
		loginPage.emailInput.sendKeys(configFileReader.getProperty("Username"));
		loginPage.passwordInput.sendKeys(configFileReader.getProperty("Password"));
		loginPage.logInButton.click();

		homePage.createPostTextBox.click();
		homePage.createPostPopUpTextBox.sendKeys("Hello World");
		homePage.postButton.click();
		Thread.sleep(5000);

	}

}
