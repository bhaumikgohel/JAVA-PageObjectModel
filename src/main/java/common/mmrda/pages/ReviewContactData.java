package common.mmrda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmrda.base.TestBase;

public class ReviewContactData extends TestBase{
	
	public ReviewContactData() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class=\"large user red icon\"]")
	WebElement usericon;
	
	public boolean Verifydata() {
		return usericon.isDisplayed();
	}

}
