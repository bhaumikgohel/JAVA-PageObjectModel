package common.mmrda.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmrda.base.TestBase;
import com.mmrda.util.Testutil;

import common.mmrda.pages.CompanyPage;
import common.mmrda.pages.HomePage;
import common.mmrda.pages.LoginPage;
import common.mmrda.pages.ReviewCompayPage;

public class VerifyCompanyDataTest extends TestBase {

	LoginPage login;
	HomePage homepage;
	CompanyPage companypage;
	ReviewCompayPage reviewcompanydata;
	
	public VerifyCompanyDataTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		
		login = new LoginPage();
		
		homepage = login.login(prop.getProperty("id"), prop.getProperty("password"));
		
		companypage = homepage.ClickOnCompanylink();
		
		reviewcompanydata = new ReviewCompayPage();
		
	}
	@Test(priority=1)
	public void VerifyCompanylistTitleTest() {
		String Title = reviewcompanydata.Verifycompanytitle();
		Assert.assertEquals(Title, "Cogmento CRM","Title Not Matched");
	}
	
	@AfterMethod
	public void terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Testutil.capturescreenshot(driver);
	}
		driver.quit();
	}
}
