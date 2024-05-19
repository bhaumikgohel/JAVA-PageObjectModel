package common.mmrda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmrda.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory 
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement submitbtn;
	
	
	public LoginPage() {
		// all the elemets initilize with driver
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public HomePage login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitbtn.click();
		
		return new HomePage();
		
	}
	
	
	
}
