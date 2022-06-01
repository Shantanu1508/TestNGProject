package SauceDemoTestNGAnnotations;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.SauceDemo.POMClass.HomePagePOMClass;
import com.SauceDemo.POMClass.LoginPagePOMClass;
import com.SauceDemo.POMClass.UtilityPOMClass;

public class BaseTestClass {
	
	WebDriver driver;
	HomePagePOMClass hm;
	LoginPagePOMClass li;
	UtilityPOMClass utility;
	//String[] loginData;
	
	
//	@BeforeSuite
//	public void setup() {
//		
//		System.out.println("Before suit");
//		System.setProperty("webdriver.chrome.driver","D:\\JAVA Materials\\chromedriver_win32\\chromedriver.exe");
//		
//	}
//	
//	@BeforeTest
//	public void openBrowser() {
//		
//		System.out.println("Before Test");
//		driver =  new ChromeDriver();
//		
//	}
	@Parameters("browserName")
	@BeforeClass
	public void setBrowser(String browserName) {
		
		if(browserName.equals("Chrome")) {
		System.out.println("Before suit");
		System.setProperty("webdriver.chrome.driver","D:\\JAVA Materials\\chromedriver_win32\\chromedriver.exe");
		
		System.out.println("Before Test");
		driver =  new ChromeDriver();
		}
		else if (browserName.equals("FireFox")) {
			
			System.out.println("Before suit");
			System.setProperty("webdriver.gecko.driver","D:\\JAVA Materials\\FireFox Driver\\geckodriver.exe");
			
			System.out.println("Before Test");
			driver =  new FirefoxDriver();
			
		}
		else if(browserName.equals("MsEgde")) {
			
			System.out.println("Before suit");
			System.setProperty("webdriver.chrome.driver","D:\\JAVA Materials\\MicroSoftEdgeDriver\\msedgedriver.exe");
			
			System.out.println("Before Test");
			driver =  new EdgeDriver();
			
		}
		else System.out.println("Please correclty set thepath of the Browser"); 
		
		
		System.out.println("Before Class");
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("URL is open");
		driver.manage().window().maximize();
		System.out.println("Browser is open successfully");
		
	}
	
	@BeforeMethod
	public void logineMethod() throws IOException, InterruptedException {
			
		System.out.println("Before Method");
			 
		
		
		 String[] loginData = UtilityPOMClass.parameterization();
		 		 
			//To enter user name
		 	li = new LoginPagePOMClass(driver);
			li.sendUsername(loginData);
			System.out.println("username is enterd");
			
			//To enter password
			li.sendPassword(loginData);
			System.out.println("password is enterd");
			

			//To click login button
			li.clickLoginButton();
			
			//To take screenshot of Home page
			UtilityPOMClass.screenshot(driver);
	}

	
	@AfterMethod
	public void logout() throws InterruptedException {
		
		
		System.out.println("After Method");
		hm = new HomePagePOMClass(driver);
		hm.dropDownOpenMenu();
		Thread.sleep(2000);
		hm.dropDownLogout();
				
	}
	
	@SuppressWarnings("deprecation")
	@AfterClass
	public void closeBrowser() throws Throwable {
		
		System.out.println("After Class");
		driver.quit();
		
		System.out.println("After Test");
		finalize();
		
	}
	
//	@SuppressWarnings("deprecation")
//	@AfterTest
//	public void finalizeMethod() throws Throwable {
//	
//		System.out.println("After Test");
//		finalize();
//		
//	}
	

}
