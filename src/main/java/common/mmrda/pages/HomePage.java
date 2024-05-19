package common.mmrda.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmrda.base.TestBase;

public class HomePage extends TestBase{

	Actions a = new Actions(driver);
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='header item']")
	WebElement logo;
	
	@FindBy(xpath="//span[text()='Bhaumik Gohel']")
	WebElement username;
	
	@FindBy(xpath="//span[@class='ui header']")
	WebElement stmsection;
	
	@FindBy(linkText = "Calendar")
	WebElement calendar;
	
	@FindBy(linkText = "Companies")
	WebElement Companieslink;
	
	@FindBy(linkText = "Contacts")
	WebElement Contactlink;
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public String validateusername() {
		return username.getText();
	}
	
	public String validatesection() {
		return stmsection.getText();
	}
	
	public String validatecontactmenu() {
		
		
		a.moveToElement(calendar).build().perform();
		
		return calendar.getText();
		
	}
	
	public CalendarPage validatecledarlink() {
		
		a.moveToElement(calendar).build().perform();
		calendar.click();
		
		return new CalendarPage();
		
	}
	public CompanyPage ClickOnCompanylink() {
		a.moveToElement(Companieslink).build().perform();
		Companieslink.click();
		
		return new CompanyPage();
	}
	public ContactPage ClickOnContactlink() {
		a.moveToElement(Contactlink).build().perform();
		Contactlink.click();
		// it return to the contact page 
		return new ContactPage();
	}
}
