package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FbHomePage {

	@FindBy(how = How.XPATH, using = "//textarea[contains(@title, 'on your mind')]")
	public WebElement createPostTextBox;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@aria-label, 'on your mind')]")
	public WebElement createPostPopUpTextBox;
	
	@FindBy(how = How.XPATH, using = "//button[descendant-or-self::*[contains(text(), 'Post')]]")
	public WebElement postButton;

	public FbHomePage(WebDriver driver) {

		// Initialize WebElements
		PageFactory.initElements(driver, this);
	}
}
