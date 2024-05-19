package common.mmrda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmrda.base.TestBase;

public class ContactPage extends TestBase{

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='selectable ']")
	WebElement ContactHeading;
	
	@FindBy(xpath = "//button[text()='Create']")
	WebElement CreateContactbtn;
	
	
	public String VerifyContactheading() {
		
		String Contactheading = ContactHeading.getText();
		
		return Contactheading;
	}
	
	public AddContactPage ClickonCreateContactButton() {
		
		
		CreateContactbtn.click();
		return new AddContactPage();
	}
	
	
}
