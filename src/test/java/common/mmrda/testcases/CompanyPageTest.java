package common.mmrda.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmrda.base.TestBase;
import com.mmrda.util.Testutil;

import common.mmrda.pages.AddCompanyData;
import common.mmrda.pages.CompanyPage;
import common.mmrda.pages.HomePage;
import common.mmrda.pages.LoginPage;

public class CompanyPageTest extends TestBase{

	LoginPage login;
	HomePage homepage;
	CompanyPage companypage;
	AddCompanyData addcompanypagetest;
	
	public CompanyPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initilization();
		login = new LoginPage();
		homepage = login.login(prop.getProperty("id"), prop.getProperty("password"));
		companypage = homepage.ClickOnCompanylink();
		addcompanypagetest = companypage.checkcompanylist();
		
	}
	
	@Test
	public void Checkcompanydata() throws InterruptedException {
		System.out.println("Test pass");
	}
	
	@AfterMethod
	public void terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Testutil.capturescreenshot(driver);
	}
		driver.quit();
	}
	
}
