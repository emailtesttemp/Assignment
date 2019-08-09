package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WhHomePage {

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Select...')]")
	public WebElement selectDropDown;

	@FindBy(how = How.XPATH, using = "//textarea[contains(@class, 'textarea')][contains(@placeholder, 'Write your review')]")
	public WebElement reviewTextArea;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'review-action')]/descendant::*[contains(@class, 'star')][4]")
	public WebElement reviewRatingFourthStar;

	// XPath of 4th Star that returns 2 WebElements when hovered over instead of 1
	public String fourthStarXpathChangeAfterHover = "//div[contains(@class, 'review-action')]//*[local-name()='svg'][4]/descendant::*[local-name()='path']";

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'review-action')]/descendant::*[contains(@class, 'star')][5]")
	public WebElement reviewRatingFifthStar;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Submit')]")
	public WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Select...')]")
	public WebElement dropDownSelect;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Health Insurance')]")
	public WebElement healthDropDownOption;

	@FindBy(how = How.XPATH, using = "//*[@id='reviews-section']/section/descendant::div[contains(@itemprop, 'description')][1]")
	public WebElement firstCompanyReview;

	public WhHomePage(WebDriver driver) {

		// Initialize WebElements
		PageFactory.initElements(driver, this);
	}
}
