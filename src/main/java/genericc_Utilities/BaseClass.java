package genericc_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepositoy.HomePage;
import pomRepositoy.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeSuite()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeTest()
	{
		System.out.println("Parallel execution Start");
	}
	
	File_Utility flib = new File_Utility();
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeClass() throws Throwable
	{
		//File_Utility flib = new File_Utility();
		//WebDriver driver;
		String BROWSER = flib.getKeyAndValueData("browser");    
	
//	public void beforeClass(String BROWSER)
//	{
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}
		System.out.println("Launch Browser");
		sdriver=driver;
	}
	
	@BeforeMethod(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeMethod() throws Throwable
	{
		//File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
		
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		System.out.println("Login to Application");
	}
	
	@AfterMethod(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void afterMethod()
	{
		HomePage home = new HomePage(driver);
		home.logOut(driver);
		System.out.println("Logout application");
	}
	
	@AfterClass(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void afterClass()
	{
		driver.close();
		System.out.println("Close Browser");
	}
	
	@AfterTest(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void afterTest()
	{
		System.out.println("Parallel Execution done");
	}
	
	@AfterSuite(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void afterSuite()
	{
		System.out.println("DataBase Connection Close");
	}

}
