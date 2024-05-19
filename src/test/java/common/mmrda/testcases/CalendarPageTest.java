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
import common.mmrda.pages.CreateNewEventPage;
import common.mmrda.pages.HomePage;
import common.mmrda.pages.LoginPage;

public class CalendarPageTest extends TestBase{

	LoginPage login;
	HomePage homepage;
	
	CalendarPage clnder;
	
	CreateNewEventPage calendarevent;
	
	public CalendarPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
	
		login = new LoginPage();
		
		homepage = login.login(prop.getProperty("id"), prop.getProperty("password"));
		
		clnder = homepage.validatecledarlink();
	}
	
	@Test(priority=1)
	public void VerifyCalendarTitleTest() {
		String calendartitle = clnder.VerifyCalendarTitle();
		
		Assert.assertEquals(calendartitle, "Cogmento CRM", "Not Match calendar Title");
		
	}
	
	@Test(priority=2)
	public void VerifyCalendarHeadingTextTest() {
		
		String calendarheader = clnder.VerifyHeading();
		
		Assert.assertEquals(calendarheader, "Calendar", "Calendar Header not match");
	}
	
	@Test(priority=3)
	public void verifynexttodaymonthsbutton() throws InterruptedException{
		
		clnder.VerifyCalendarButton();
		
	}
	
	@Test(priority=4)
	public void ClickOnCalenderCreateButton() {
		calendarevent = clnder.VerifyCreateNewEventButton();
		
	}
	
	@AfterMethod
	public void terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Testutil.capturescreenshot(driver);
	}
		driver.quit();
	}
}
