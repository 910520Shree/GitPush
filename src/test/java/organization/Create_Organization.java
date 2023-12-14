package organization;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericc_Utilities.BaseClass;
import genericc_Utilities.Excel_Utility;
import genericc_Utilities.File_Utility;
import genericc_Utilities.Java_Utility;
import genericc_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepositoy.CampaignPlusSignPage;
import pomRepositoy.CreateCampaignPage;
import pomRepositoy.CreateOrganizationPage;
import pomRepositoy.HomePage;
import pomRepositoy.LoginPage;
import pomRepositoy.OrganizationHOmePage;
import pomRepositoy.ValidationPage;

//@Listeners(genericc_Utilities.ListenerImplementation.class)
public class Create_Organization extends BaseClass{
	
	@Test(groups = "SmokeTest")
//	public static void main(String[] args) throws Throwable {
	public void Create_OrganizationTest() throws Throwable {
//		File_Utility flib = new File_Utility();
		
//		WebDriver driver;
//		String BROWSER = flib.getKeyAndValueData("browser");
//		if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else
//		{
//			driver = new EdgeDriver();
//		}
//		
		//launching the browser
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
		
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		
		wlib.maximizingWindow(driver);
		wlib.implicit_Wait(driver);
		
		//implicit_wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		String URL = flib.getKeyAndValueData("url");
//		String USERNAME = flib.getKeyAndValueData("username");
//		String PASSWORD = flib.getKeyAndValueData("password");
//		
//		driver.get(URL);
		//BusinessLogics
//		LoginPage login = new LoginPage(driver);
//		login.loginToApplication(USERNAME, PASSWORD);
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//login to Vtiger application
//		driver.get("http://localhost:8888/");
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
		
		//click on create organization link
		//driver.findElement(By.linkText("Organizations")).click();
		HomePage home = new HomePage(driver);
		home.clickOnOrganizationLink();
		
		//click on lookup image +sign
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		OrganizationHOmePage orgPlus = new OrganizationHOmePage(driver);
		orgPlus.clickOrganizationPlus();
		
		//Random approach to avoid duplicates
		int ranNum = jlib.getRandomNum();
		
		//Random approach
		/*Random ran = new Random();
		int ranNum = ran.nextInt(1000);*/
		
		//navigate to create org. page-->provide org name
		String orgname = elib.getDataFormatterData("organizations", 0, 0)+ranNum;
		String phone="1122334455";
		String email="abc@gmail.com";
//		driver.findElement(By.name("accountname")).sendKeys(orgname);
		CreateOrganizationPage plus = new CreateOrganizationPage(driver);
		plus.orgNameSave(orgname,phone,email);
		Assert.assertEquals(true, true);
		
		//click on save button
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validate Org name is created
		ValidationPage orgVal = new ValidationPage(driver);
		String actData = orgVal.orgValidate();
		Assert.assertEquals(actData, orgname);
/*		Thread.sleep(2000);
		String orgName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();		//String orgName = driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[1]")).getText();
		
		if(orgName.contains(orgname))
		{
			System.out.println("Organization Created");
		}
		else
		{
			System.out.println("Organization not Created");
		}*/
		
		//logout from application
		/*Thread.sleep(2000);	
		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHover(driver, signOut);
//		Actions a = new Actions(driver);
//		a.moveToElement(signOut).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//*-->replaces tag name, .-->replaces text() function---use only 1 out of 1*/
//		home.logOut(driver);
		
	}
	@Test
	public void m1org()
	{
		Assert.assertEquals(false, true);
		System.out.println("Method m1org");
	} 
	@Test
	public void m2org()
	{
		Assert.assertEquals(false, true);
		System.out.println("Method m2org");
	}         
}
