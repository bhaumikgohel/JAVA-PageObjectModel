package common.mmrda.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmrda.base.TestBase;

public class CalendarPage extends TestBase{

	
	public CalendarPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Calendar')]")
	WebElement calendarheading;
	
	@FindBy(xpath = "//button//i[@class='chevron right icon']")
	WebElement nextmonthbtn;
	
	@FindBy(xpath = "//button//span[@class='today-button']")
	WebElement todaybtn;
	
	@FindBy(xpath = "//button//span[contains(text(),'Week')]")
	WebElement Weekbtn;
	
	@FindBy(xpath = "//button//span[contains(text(),'Day')]")
	WebElement daybtn;
	
	
	
	@FindBy(xpath="//button[contains(text(),'Events')]")
	WebElement clickoneventbtn;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement createeventbtn;
	
	public String VerifyCalendarTitle() {
		return driver.getTitle();
	}
	
	public String VerifyHeading() {
		return calendarheading.getText();
	}
	
	public void VerifyCalendarButton() throws InterruptedException {
		nextmonthbtn.click();

		Thread.sleep(2000);
		todaybtn.click();
		
		Thread.sleep(2000);
		Weekbtn.click();
		
		Thread.sleep(2000);
		daybtn.click();
		
	}
	
	public CreateNewEventPage VerifyCreateNewEventButton() {
		
		createeventbtn.click();
		
		return new CreateNewEventPage();
		
	}
	
	public VerifyEventPage Clickoneventbutton() {
		clickoneventbtn.click();
		
		return new VerifyEventPage();
	}
	
}
