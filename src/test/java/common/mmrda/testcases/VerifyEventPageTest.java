package common.mmrda.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mmrda.base.TestBase;
import com.mmrda.util.Testutil;

import common.mmrda.pages.CalendarPage;
import common.mmrda.pages.HomePage;
import common.mmrda.pages.LoginPage;
import common.mmrda.pages.VerifyEventPage;

public class VerifyEventPageTest extends TestBase{
	
	LoginPage login;
	HomePage homepage;
	CalendarPage calendar;
	VerifyEventPage eventpage;

	public VerifyEventPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		login = new LoginPage();
		homepage = login.login(prop.getProperty("id"), prop.getProperty("password"));
		calendar = homepage.validatecledarlink();
		eventpage = calendar.Clickoneventbutton();
	}
	
	@Test(priority=1)
	public void VerifyEventDataTest() throws InterruptedException {
		
		String Nodatafoundmsg = eventpage.Verifyeventdata();
		
		if(Nodatafoundmsg.equals("No records found")) {
			Assert.fail("Data Not Found");
		}
		else {
			eventpage.rating();
			
			Thread.sleep(5000);
			eventpage.setnotification();
		}
		
	}
	
	@Test(priority=2,dependsOnMethods = "VerifyEventDataTest")
	public void VerifyDeleteEventTest() throws InterruptedException {
		eventpage.Verifyeventdata();
		
		eventpage.DeleteEvent();
		
	}
	
	@AfterMethod
	public void terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Testutil.capturescreenshot(driver);
	}
		driver.quit();
	}
}
