package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import config.InitializeDriver;
import pages.CreateNewSurvey;

public class LaunchSurveyAdminTest extends InitializeDriver {
	
	WebDriver driver;
	
	WebDriverWait wait;
	CreateNewSurvey createNewSurvey;
	
	
	@BeforeMethod()
	public void setup() {
		driver = getChromeDriver();
		wait = getWebDriverWait(driver);	
	}
  
  @Test()
  public void createSurvey() {
	  CreateNewSurvey createNewSurvey = new CreateNewSurvey(driver,wait);  
	  createNewSurvey.createNewSurvey();
  }
  
  @AfterMethod()
	public void closure() {	
		driver.quit();
	}
  
  
}
