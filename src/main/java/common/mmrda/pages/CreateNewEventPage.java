package common.mmrda.pages;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mmrda.base.TestBase;

public class CreateNewEventPage extends TestBase{
	
	
	int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    
    Random random = new Random();
    
    
    @FindBy(xpath="//input[@name='title']")
    WebElement EventTitle;
	
 
    @FindBy(xpath="//textarea[@name='description']")
    WebElement EventDescription;
    
    @FindBy(xpath="//button[@class='ui linkedin button']")
    WebElement Savebtn;
    
	public CreateNewEventPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyurltext() {
		return driver.getCurrentUrl();
	}

	public void EventTitle(String eventtitle, String eventdescription) {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(); 
		   
		   EventTitle.sendKeys(eventtitle + dtf.format(now));
		   EventDescription.sendKeys(eventdescription);
		   
//		EventTitle.sendKeys(prop.getProperty("eventtitle") + dtf.format(now));

//		EventDescription.sendKeys(dtf.format(now));
	}
	
	public VerifyEventPage CreateNewEvent() throws InterruptedException {
		Savebtn.click();
		
		Thread.sleep(5000);
		
		return new VerifyEventPage();
	}
	
	 
}
