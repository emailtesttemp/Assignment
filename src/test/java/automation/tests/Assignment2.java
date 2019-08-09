package automation.tests;

import static common.utilities.CommonConstants.LARGE_TEXT;
import static common.utilities.CommonConstants.TIMEOUT;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.utilities.ConfigFileReader;
import page.objects.WhHomePage;
import page.objects.WhLoginPage;
import page.objects.WhProfilePage;

public class Assignment2 extends Base {

	// Initialize Page Objects
	ConfigFileReader configFileReader;
	WhHomePage homePage;
	WhLoginPage loginPage;
	WhProfilePage profilePage;

	@Test(priority = 0)
	public void provideReview() throws InterruptedException, IOException {

		homePage = new WhHomePage(driver);
		loginPage = new WhLoginPage(driver);

		// Launch URL
		driver.get("http://wallethub.com/profile/test_insurance_company/");

		// Steps For Hovering & Clicking Stars
		new Actions(driver).moveToElement(homePage.reviewRatingFourthStar).build().perform();
		new WebDriverWait(driver, TIMEOUT)
				.until(ExpectedConditions.numberOfElementsToBe(By.xpath(homePage.fourthStarXpathChangeAfterHover), 2));
		homePage.reviewRatingFifthStar.click();

		// Select Health Insurance From Drop-down
		homePage.selectDropDown.click();
		homePage.healthDropDownOption.click();

		// Provide Review Text > 200 Chars
		homePage.reviewTextArea.sendKeys(LARGE_TEXT);
		homePage.submitButton.click();

		// Switch To Login Tab
		loginPage.loginTab.click();

	}

	@Test(priority = 1)
	public void loginToApplication() throws IOException {

		configFileReader = new ConfigFileReader();
		loginPage = new WhLoginPage(driver);

		// Provide WalletHub Credentials & Login
		loginPage.usernameInputField.sendKeys(configFileReader.getProperty("Username"));
		loginPage.passwordInputField.sendKeys(configFileReader.getProperty("Password"));
		loginPage.loginButton.click();
	}

	@Test(priority = 2)
	public void validateReview() throws InterruptedException, IOException {

		configFileReader = new ConfigFileReader();
		profilePage = new WhProfilePage(driver);

		// Wait for Review to Appear
		new WebDriverWait(driver, TIMEOUT)
				.until(ExpectedConditions.textToBePresentInElement(homePage.firstCompanyReview, LARGE_TEXT));

		// Navigate to Review Section for Current User
		driver.get("https://wallethub.com/profile/" + configFileReader.getProperty("Username").split("@")[0]
				+ "/reviews/");
		profilePage.reviewButton.click();

		// Validate Review
		assertTrue(profilePage.firstReview.getText().equals(LARGE_TEXT));

		// Removing Review Post Validation
		profilePage.removeFirstReviewLink.click();

	}

}
