package common.mmrda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmrda.base.TestBase;

public class CompanyPage extends TestBase{

	public CompanyPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div//p[text()='No records found']")
	WebElement Nodatafound;
	
	@FindBy(xpath="//button[text()='Create']")
	WebElement Create;
	
	public AddCompanyData checkcompanylist() throws InterruptedException {
		
		String norecord = Nodatafound.getText();
		
		if 	(norecord.equals("No records found"))
		{
			System.out.println("Data not Found");
		}
		else
		{
		
			Thread.sleep(5000);
			Create.click();
			
		}

		return new AddCompanyData();
		
	}
	
	public AddCompanyData ClickOnAddCompanyButton() {
		Create.click();
		return new AddCompanyData();
	}
}
	
