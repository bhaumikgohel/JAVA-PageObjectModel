package common.mmrda.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmrda.base.TestBase;
import com.mmrda.util.Testutil;

public class ReviewCompayPage extends TestBase{

	public ReviewCompayPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//td//a)[1]")
	WebElement Firstcompanyname;
	
	
	public String Verifycompanytitle() {
		
		
		Testutil.clickOn(driver, Firstcompanyname, Duration.ofSeconds(20));
		return driver.getTitle();
		
	}
	
}
