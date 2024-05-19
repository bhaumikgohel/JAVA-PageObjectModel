package com.mmrda.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Automation\\common\\src\\main\\java\\com\\mmrda\\config\\config.properties");
		prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initilization() {
		
		
		
		String Browsers = prop.getProperty("browser");
		
		if(Browsers.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\common\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browsers.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\common\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		driver.get(prop.getProperty("loginurl"));
		
	}
	
}
