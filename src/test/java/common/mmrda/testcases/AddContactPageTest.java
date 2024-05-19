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

import common.mmrda.pages.AddContactPage;
import common.mmrda.pages.ContactPage;
import common.mmrda.pages.HomePage;
import common.mmrda.pages.LoginPage;
import common.mmrda.pages.ReviewContactData;

public class AddContactPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage Homepage;
	ContactPage Contactpage;
	AddContactPage Addcontactpage;
	ReviewContactData reviewcontactdata;
	String contactsheet = "contactdata";
	
	public AddContactPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void Setup() {
		initilization();
		
		loginpage = new LoginPage();
		
		Homepage = loginpage.login(prop.getProperty("id"), prop.getProperty("password"));
		
		Contactpage = Homepage.ClickOnContactlink();
		
		Addcontactpage = Contactpage.ClickonCreateContactButton();
		
	}
	
	@Test(priority=1)
	public void VerifyrequiredfiedsTest() {
		String validation = Addcontactpage.Checkrequiredfieldtextmessage();
		
		Assert.assertEquals(validation, "The field First Name is required.", "Required field not matchedl");
	}
	
	@DataProvider
	public Object[][] getContactdata(){
		
		Object data[][] = Testutil.getContactData(contactsheet);
		return data;
		
	}
	
	
	@Test(priority=2,dataProvider = "getContactdata")
	public void Add_contactpage_Data_Test(String firstname, String lastname, String middlename, String description, String address, String city, String state, String mob) {
		
		
		reviewcontactdata = Addcontactpage.AddContactData(firstname, lastname, middlename, description, address, city, state, mob);
		reviewcontactdata.Verifydata();
		
	}
	
	
	@AfterMethod
	public void Terminate(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
				Testutil.capturescreenshot(driver);
		}
		driver.quit();
	}

}
