package common.mmrda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmrda.base.TestBase;
import com.mmrda.util.Testutil;

public class AddCompanyData extends TestBase{

	public AddCompanyData() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='name' and @autocomplete='new-password'] ")
	WebElement CompanyName;
	
	@FindBy(xpath="//input[@name='value' and @placeholder='Email address']")
	WebElement CompanyEmail;
	
	@FindBy(xpath="//textarea[@name='description' and @autocomplete='new-password']")
	WebElement CompayDescription;
	
	@FindBy(xpath="//button[@class=\"ui linkedin button\"]")
	WebElement Savebtn;
	
	@FindBy(xpath="//span[text()=\"Create new Company\"]")
	WebElement CompanyPageHeading;
	
	public String Verifycompanyheading() {
		return CompanyPageHeading.getText();
	}
	
	public ReviewCompayPage Addcompanydata(String name,String email, String des) {
		
		CompanyName.sendKeys(name);
		CompanyEmail.sendKeys(email);
		CompayDescription.sendKeys(des);
		Savebtn.click();
		
		return new ReviewCompayPage();
		
	}
}
