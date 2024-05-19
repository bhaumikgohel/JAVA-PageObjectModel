package common.mmrda.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mmrda.base.TestBase;
import com.mmrda.util.Testutil;

import common.mmrda.pages.AddCompanyData;
import common.mmrda.pages.CompanyPage;
import common.mmrda.pages.HomePage;
import common.mmrda.pages.LoginPage;
import common.mmrda.pages.ReviewCompayPage;

public class AddCompanyPageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	CompanyPage companypage;
	AddCompanyData addcompanypagedata;
	ReviewCompayPage reviewcompanypage;
	
	String sheetName = "companydata";
	
	public AddCompanyPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		login = new LoginPage();
		homepage = login.login(prop.getProperty("id"), prop.getProperty("password"));
		companypage = homepage.ClickOnCompanylink();
	}
	
	@Test(priority=1)
	public void CheckCompanyPageHeadingTest() {
		String companypageheading = addcompanypagedata.Verifycompanyheading();
		
		Assert.assertEquals(companypageheading, "Create new Company","Company Page Heading not found");
		
	}
	
	@DataProvider
	public Object[][] GetCompanyTestData() {
		
		Object data[][] = Testutil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider = "GetCompanyTestData")
	public void validateAddCompanyData(String name, String email, String description) throws InterruptedException {
		
		addcompanypagedata = companypage.ClickOnAddCompanyButton();
		reviewcompanypage = addcompanypagedata.Addcompanydata(name, email, description);
		
	}
	
	@AfterMethod
	public void terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Testutil.capturescreenshot(driver);
	}
		driver.quit();
	}

}
