package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WhProfilePage {
		
		@FindBy(how = How.XPATH, using = "//a[contains(@href, 'profile')][ancestor::li[@class='selected']]")
		public WebElement reviewButton;
		
		@FindBy(how = How.XPATH, using = "//div[@class='reviews']/div[contains(@class, 'review-first')]/descendant::p")
		public WebElement firstReview;
		
		@FindBy(how = How.XPATH, using = "//a[@class='remove']")
		public WebElement removeFirstReviewLink;
	
		public WhProfilePage(WebDriver driver) {
	
			// Initialize WebElements
			PageFactory.initElements(driver, this);
		}
}

