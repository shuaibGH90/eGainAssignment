package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchSurveyAdmin  {

	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement createNewSurveyButton;

	@FindBy(xpath="//div[@class='row']//h4")
	private WebElement createNewSurvey;
	
	@FindBy(xpath="//td[@class='col-sm'][not(preceding-sibling::td[@class='col-sm'])]")
	private WebElement surveyName;
	
	@FindBy(xpath="//td[@class='col-sm'][not(following-sibling::td[@class='col-sm'])]")
	private WebElement status;

	 WebDriver driver;
	 
	 WebDriverWait wait;
	
	public  LaunchSurveyAdmin(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = wait;	
        driver.get("http://survey-ui.s3-website-us-east-1.amazonaws.com/");
    }
	
	
	public void clickCreateNewSurveyButton() {	
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(createNewSurveyButton)));
		createNewSurveyButton.click();
	}
	
	public void verifyCreateNewSurveyPageIsLaunched() {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElement(createNewSurvey, "Create New Survey")));
	}

	public String getSurveyName() {
		return surveyName.getText();
	}
	
	public String getStatus() {
		return status.getText();
	}
}
