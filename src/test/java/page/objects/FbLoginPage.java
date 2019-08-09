package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPage {

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'email')]")
	public WebElement emailInput;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'pass')]")
	public WebElement passwordInput;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Log In']")
	public WebElement logInButton;

	// Constructor invoking initElements
	public FbLoginPage(WebDriver driver) {

		// Initialize WebElements
		PageFactory.initElements(driver, this);
	}

}
