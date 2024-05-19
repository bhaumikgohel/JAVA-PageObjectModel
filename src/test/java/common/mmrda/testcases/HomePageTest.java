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

public class HomePageTest extends TestBase{
	HomePage homepage;
	LoginPage loginpage;
	CalendarPage clnder;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		loginpage = new LoginPage();
		
		homepage = loginpage.login(prop.getProperty("id"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void validatepagetitle() {
		String unname = homepage.validateusername();
		Assert.assertEquals(unname, "Bhaumik Gohel", "User Name Not matched");
	}
	
	@Test(priority=2)
	public void validateLogo(){
		
		Boolean flag = homepage.validateLogo(); 
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void validatesection() {
		String section = homepage.validatesection();
		Assert.assertEquals(section, "System messages", "Not match");
	}
	
	@Test(priority=4)
	public void validatecontact() {
		String contactsidemenu = homepage.validatecontactmenu();
		Assert.assertEquals(contactsidemenu, "Calendar", "Not match");
	}
	
	
	@Test(priority=5)
	public void validateconatctlink() {
		clnder = homepage.validatecledarlink();
		
	}
	
	@AfterMethod
	public void terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Testutil.capturescreenshot(driver);
	}
		driver.quit();
	}

}
