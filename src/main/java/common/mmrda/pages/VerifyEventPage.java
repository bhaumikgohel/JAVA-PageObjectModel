package common.mmrda.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmrda.base.TestBase;

public class VerifyEventPage extends TestBase {
	
	public VerifyEventPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a)[27]")
	WebElement Verifyaddalertrow;
	
	@FindBy(xpath="//div//i[@aria-posinset='4']")
	WebElement rating;
	
	@FindBy(xpath="//i[@class='red bell outline icon']")
	WebElement pendingalerts;	
	
	@FindBy(xpath="//button[contains(text(),'Close')]")
	WebElement Closepopup;
	
	@FindBy(xpath="//i[@class='remove icon']")
	WebElement ConfirmDeletebutton;
	
	@FindBy(xpath="(//i)[50]")
	WebElement Removefilter;
	
	@FindBy(xpath="//div//p[text()='No records found']")
	WebElement norecordfoundtext;
	
	@FindBy(xpath="//button//i[@class='trash icon']")
	WebElement Deletebutton;
	
	public String Verifyeventdata() throws InterruptedException {
		
		String norecord = norecordfoundtext.getText();
		
		if 	(norecord.equals("No records found"))
		{
			System.out.println("Data not Found");
		}
		else
		{
		
			Thread.sleep(5000);
			Verifyaddalertrow.click();
			
		}

		return norecordfoundtext.getText();
		
	}
	
	public void rating() {
		rating.click();
	}
	
	public void setnotification() throws InterruptedException {
		
		Thread.sleep(5000);
		pendingalerts.click();
		
		Thread.sleep(5000);
		Closepopup.click();
	}
	
	public void DeleteEvent() throws InterruptedException {
			
		
		Deletebutton.click();
		Thread.sleep(5000);
		ConfirmDeletebutton.click();
		Thread.sleep(5000);
		System.out.println("Delete Confirmed");
	}
	
	
}
