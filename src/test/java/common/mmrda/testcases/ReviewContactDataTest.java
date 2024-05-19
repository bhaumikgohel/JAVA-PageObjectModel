package common.mmrda.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mmrda.base.TestBase;
import com.mmrda.util.Testutil;

import common.mmrda.pages.ReviewContactData;

public class ReviewContactDataTest extends TestBase{
	
	ReviewContactData reviewcontactpage;
	
	public ReviewContactDataTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		reviewcontactpage = new ReviewContactData();
	}
	
	@Test(priority=1)
	public void VerifycontactdataTest() {
		reviewcontactpage.Verifydata();
	}
	
	@AfterMethod
	public void Terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Testutil.capturescreenshot(driver);
	}
		driver.quit();
	}
}
