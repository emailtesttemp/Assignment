package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WhLoginPage {
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')][contains(@ng-click, 'login')]")
	public WebElement loginTab;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email Address']")
	public WebElement usernameInputField;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	public WebElement passwordInputField;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Login')]")
	public WebElement loginButton;

	public WhLoginPage(WebDriver driver) {

		// Initialize WebElements
		PageFactory.initElements(driver, this);
	}
}
