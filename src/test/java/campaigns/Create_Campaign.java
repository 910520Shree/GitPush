package campaigns;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericc_Utilities.BaseClass;
import genericc_Utilities.Excel_Utility;
import genericc_Utilities.File_Utility;
import genericc_Utilities.Java_Utility;
import genericc_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepositoy.CampaignPlusSignPage;
import pomRepositoy.CreateCampaignPage;
import pomRepositoy.HomePage;
import pomRepositoy.LoginPage;
import pomRepositoy.ValidationPage;

public class Create_Campaign extends BaseClass {

	@Test(groups = "RegressionTest")
//	public static void main(String[] args) throws Throwable {
	public void Create_CampaignTest() throws Throwable {
		
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
		
		Java_Utility jlib = new Java_Utility();
//		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		
		wlib.maximizingWindow(driver);
		wlib.implicit_Wait(driver);
		
//		String URL = flib.getKeyAndValueData("url");
//		String USERNAME = flib.getKeyAndValueData("username");
//		String PASSWORD = flib.getKeyAndValueData("password");
//		
//		driver.get(URL);
		//HardCoding
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//getter methods
//		LoginPage login = new LoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
		//BusinessLogics
//		LoginPage login = new LoginPage(driver);
//		login.loginToApplication(USERNAME, PASSWORD);
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		driver.get("http://localhost:8888/");
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
//		
		//WebElement more = driver.findElement(By.linkText("More"));
		//wlib.mouseHover(driver, more);
//		Actions a = new Actions(driver);
//		a.moveToElement(more).perform();
		//driver.findElement(By.linkText("Campaigns")).click();
		HomePage home = new HomePage(driver);
//		home.clickOnMoreLink();
//		home.clickOnCampaignsLik();
		home.mouseHoverOnMoreLink(driver);
		
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampaignPlusSignPage campPlus = new CampaignPlusSignPage(driver);
		campPlus.clickCampaignPlus();
		
		//Random approach to avoid duplicates
		int ranNum = jlib.getRandomNum();
		
		/*Random ran = new Random();
		int ranNum = ran.nextInt(1000);*/
		String campname = elib.getDataFormatterData("Campaigns", 0, 0)+ranNum;
		Assert.assertEquals(false, true);
		/*driver.findElement(By.name("campaignname")).sendKeys(campname);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();*/
		CreateCampaignPage plus = new CreateCampaignPage(driver);
		plus.campaignName(campname);
		//plus.clickOnCampSave();
		
		//validate campaign name is created
		Thread.sleep(2000);
		//String campName = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		ValidationPage campVal = new ValidationPage(driver);
		String actData = campVal.campValidate();
		//Assert.assertEquals(actData, campname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actData, campname);
		soft.assertAll();
				
//		if(actData.contains(campname))
//		{
//			System.out.println("Campaign Created");
//		}
//		else
//		{
//			System.out.println("Campaign not Created");
//		}
		
		//logout from application
		/*Thread.sleep(2000);	
		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHover(driver, signOut);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//*-->replaces tag name, .-->replaces text() function---use only 1 out of 1*/
		//home.logOut(driver);

	}
	
	@Test
	public void m1()
	{
		System.out.println("Method m1");
		Assert.assertEquals(true, true);
	}

}
