package common.mmrda.testcases;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mmrda.base.TestBase;
import com.mmrda.util.Testutil;

import common.mmrda.pages.CalendarPage;
import common.mmrda.pages.CreateNewEventPage;
import common.mmrda.pages.HomePage;
import common.mmrda.pages.LoginPage;
import common.mmrda.pages.VerifyEventPage;

public class CreateNewEventTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	CalendarPage cldar;
	CreateNewEventPage createvent;
	VerifyEventPage verifyeventpage;
	
	String Eventdata = "eventdata";
	
	public CreateNewEventTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("id"),prop.getProperty("password"));
		cldar = homepage.validatecledarlink();
		createvent = cldar.VerifyCreateNewEventButton();
	}

	@Test(priority=1)
	public void VerifyCreateNewEventHeading() {
		String url = createvent.verifyurltext();
		System.out.println(url);
	}
	
	@DataProvider
	public Object[][] getEventData() {
		
		Object data[][] = Testutil.getTestData(Eventdata);
		return data;
	}
	
	@Test(priority=2, dataProvider = "getEventData")
	public void Entereventdata(String eventtitle, String eventdescription) throws InterruptedException {
		createvent.EventTitle(eventtitle,eventdescription);
		verifyeventpage = createvent.CreateNewEvent();
	}
	
	
	@AfterMethod
	public void terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Testutil.capturescreenshot(driver);
	}
		driver.quit();
	}
	
	
}
