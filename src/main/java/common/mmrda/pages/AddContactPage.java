package common.mmrda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mmrda.base.TestBase;

public class AddContactPage extends TestBase{
	
	public AddContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement Firstname;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement Lastname;
	
	@FindBy(xpath = "//input[@name='middle_name']")
	WebElement Middlename;

	@FindBy(xpath = "//button[text()='Public']")
	WebElement Accessbutton;
	
	
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;
	
	@FindBy(xpath = "//button[text()=\"Save\"]")
	WebElement savebtn;
	
	//span[text()="The field First Name is required."]
	
	@FindBy(xpath = "//span[text()=\"The field First Name is required.\"]")
	WebElement firstnamerequiredmessage;
	
	@FindBy(xpath = "//span[text()=\"The field Last Name is required.\"]")
	WebElement lastnamerequiredmessage;
	
	
	@FindBy(xpath="//div[@name=\"category\"][1]")
	WebElement categorydropdown;
	
	@FindBy(xpath="//span[text()='Customer']")
	WebElement catdropdownvalue;
	
			
	@FindBy(xpath="//div[@name=\"status\"][1]")
	WebElement Status;
	
	@FindBy(xpath="//span[text()='Active']")
	WebElement Activestatus;
	
	
	@FindBy(xpath = "//input[@name='address']")
	WebElement contactaddress;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement contactcity;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement contactstate;
	
			
	@FindBy(xpath = "(//input[@name='value'])[3]")
	WebElement Mobilenumber;
	
	public String Checkrequiredfieldtextmessage( ) {
		savebtn.click();
		
		String firstnamelabel = firstnamerequiredmessage.getText();
		
		return firstnamelabel;
		
	}
	
	public ReviewContactData AddContactData(String fname, String lname, String mname, String des, String add, String city, String state, String mob) {
		
		Firstname.sendKeys(fname);
		Lastname.sendKeys(lname);
		Middlename.sendKeys(mname);
		description.sendKeys(des);
		Accessbutton.click();
		categorydropdown.click();
		catdropdownvalue.click();
		
		Status.click();
		Activestatus.click();
		
		contactaddress.sendKeys(add);
		contactcity.sendKeys(city);
		contactstate.sendKeys(state);
		Mobilenumber.sendKeys(mob);
		
		savebtn.click();

		return new ReviewContactData();
	}
	
	
}


