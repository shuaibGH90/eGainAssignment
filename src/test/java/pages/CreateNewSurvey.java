package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.assertj.core.api.Assertions;

public class CreateNewSurvey {
	
    @FindBy(xpath="//input[@id='inlineRadio1']")
    private WebElement activeRadioButton;
    
    @FindBy(id="inputName")
    private WebElement surveyNameInput;

    @FindBy(id="inputDate")
    private WebElement surveyExpiryDateInput;
    
    @FindBy(id="inputURL")
    private WebElement surveyURLInput;
  
    @FindBy(xpath="//input[@id='inputEmail']")
    private WebElement surveyFromEmailAddressInput;
    
    @FindBy(xpath="//input[@id='inlineCheckbox1']")
    private WebElement caseClosureCheckbox;
    
    @FindBy(xpath="//input[@id='inlineCheckbox2']")
    private WebElement activeClosureCheckbox;
    
    @FindBy(xpath="//select[@id='inputState']")
    private WebElement surveyAccessbilityDropDown;
    
    @FindBy(xpath="//button[text()='Submit']")
    private WebElement submitButton;
    
    WebDriver driver;
	 
	WebDriverWait wait;
	
	public CreateNewSurvey(WebDriver driver, WebDriverWait wait){
       this.driver = driver;
       PageFactory.initElements(driver, this);
       this.wait = wait;
   }
    
  
    public void createNewSurvey() {
    	LaunchSurveyAdmin launchSurveyAdmin = new LaunchSurveyAdmin(driver,wait);	
    	for(int i=1; i<=5; i++) {
    		launchSurveyAdmin.clickCreateNewSurveyButton();
    		launchSurveyAdmin.verifyCreateNewSurveyPageIsLaunched();
    		activeRadioButton.click();
        	surveyNameInput.sendKeys("eGain Survey "+i);
        	surveyExpiryDateInput.sendKeys("12/0"+i+"/2020");
        	surveyURLInput.sendKeys("https://www.egain.com/");
        	caseClosureCheckbox.click();
        	activeClosureCheckbox.click();	
        	selectOption("UserGroup"+i);
        	submitButton.click();  
        	Assertions.assertThat(launchSurveyAdmin.getSurveyName()).as("Survey name is not right").contains("eGain Survey "+i);
        	Assertions.assertThat(launchSurveyAdmin.getStatus()).as("Status is not correct").contains("Active");
    	}  	
    }
    
    public void selectOption(String option) {
     	if (option.endsWith("5")) {
     		option = "UserGroup1";
     	}
    	Select surveyAccessbility = new Select(surveyAccessbilityDropDown);
    	surveyAccessbility.selectByVisibleText(option);
    }
    
   
  
}
