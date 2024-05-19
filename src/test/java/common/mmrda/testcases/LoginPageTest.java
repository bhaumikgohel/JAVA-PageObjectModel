package common.mmrda.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mmrda.base.TestBase;
import com.mmrda.util.Testutil;

import common.mmrda.pages.HomePage;
import common.mmrda.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	// Super class constructor call then it will go to initilize the method call
	
	@BeforeMethod
	public void setup() {
		
		initilization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginpageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test(priority=2)
	public void logintest() {
		// it return to home page 
		homePage = loginpage.login(prop.getProperty("id"), prop.getProperty("password"));
		
	}

	@AfterMethod
	public void terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Testutil.capturescreenshot(driver);
	}
		driver.quit();
	}
}
