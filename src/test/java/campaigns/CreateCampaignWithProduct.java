package campaigns;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericc_Utilities.BaseClass;
import genericc_Utilities.Excel_Utility;
import genericc_Utilities.File_Utility;
import genericc_Utilities.Java_Utility;
import genericc_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepositoy.CampaignPlusSignPage;
import pomRepositoy.CreateCampaignPage;
import pomRepositoy.CreateProductPage;
import pomRepositoy.HomePage;
import pomRepositoy.LoginPage;
import pomRepositoy.ProductHomePage;
import pomRepositoy.ProductWindowPage;
import pomRepositoy.ValidationPage;

public class CreateCampaignWithProduct extends BaseClass{

	@Test
//	public static void main(String[] args) throws Throwable {
	public void CreateCampaignWithProductTest() throws Throwable{
		//launching the browser
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
		
		Java_Utility jlib = new Java_Utility();
//		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		
		wlib.maximizingWindow(driver);
		wlib.implicit_Wait(driver);
		
		//driver.manage().window().maximize();		
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
//		//login to Vtiger application
//		driver.get("http://localhost:8888/");
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
				
		//click on create product link
		//driver.findElement(By.linkText("Products")).click();
		HomePage home = new HomePage(driver);
		home.clickOnProductLink();
				
		//click on lookup image +sign
//		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		ProductHomePage prodPlus = new ProductHomePage(driver);
		prodPlus.clickProductPlus();
		
		//Random approach
		int ranNum = jlib.getRandomNum();
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
				
		//navigate to create product page-->provide product name
		//String name = "Bluetooth"+ranNum;
		String prdName = elib.getDataFormatterData("product", 0, 0)+ranNum;
//		driver.findElement(By.name("productname")).sendKeys(prdName);
		CreateProductPage plus = new CreateProductPage(driver);
		plus.productNameSave(prdName);
				
		//click on save button  
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//validate product name is created
		ValidationPage prdVal = new ValidationPage(driver);
		String actDta = prdVal.prdValidate();
		Assert.assertEquals(actDta, prdName);
/*		Thread.sleep(2000);
		String prodName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();		//String orgName = driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[1]")).getText();
				
		if(prodName.contains(prdName))
		{
			System.out.println("Product Created");
		}
		else
		{
			System.out.println("Product not Created");
		}*/
		
		/*WebElement more = driver.findElement(By.linkText("More"));
		wlib.mouseHover(driver, more);
//		Actions a = new Actions(driver);
//		a.moveToElement(more).perform();
		driver.findElement(By.linkText("Campaigns")).click();*/
		home.mouseHoverOnMoreLink(driver);
//		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampaignPlusSignPage campPlus = new CampaignPlusSignPage(driver);
		campPlus.clickCampaignPlus();
		ProductWindowPage prdWin = new ProductWindowPage(driver);
		prdWin.clickOnPrdPlusSign(driver, wlib);
//		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//Switching window
//		wlib.windowSwitching(driver, "Products&action");
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> window = windows.iterator();
//		
//		while(window.hasNext())
//		{
//			String win = window.next();
//			driver.switchTo().window(win);
//			String title = driver.getTitle();
//			
//		if(title.contains("Products&action"))
//		{
//			break;
//
//		}
//		}	
		prdWin.productNameSearch(prdName);
		prdWin.selectProduct(driver, wlib, prdName);
	/*	driver.findElement(By.name("search_text")).sendKeys(prdName);
		driver.findElement(By.name("search")).click();
		
		//dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
		
		wlib.windowSwitching(driver, "Campaigns&action");        */
//		Set<String> windows1 = driver.getWindowHandles();
//		Iterator<String> window1 = windows1.iterator();
//		while(window1.hasNext())
//		{
//			String win1 = window1.next();
//			driver.switchTo().window(win1);
//			String title1 = driver.getTitle();
//			
//		if(title1.contains("Campaigns&action"))
//		{
//			break;
//
//		}
//		}	
		
		String cmpName = elib.getDataFormatterData("Campaigns", 0, 0)+ranNum;
//		String cmpName = "Spiders"+ranNum;
		CreateCampaignPage plusCamp = new CreateCampaignPage(driver);
		plusCamp.campaignName(cmpName);
//		driver.findElement(By.name("campaignname")).sendKeys(cmpName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validate campaign name is created
		ValidationPage campVal = new ValidationPage(driver);
		String actData = campVal.campValidate();
		Assert.assertEquals(actData, cmpName);	/*	Thread.sleep(2000);
		String campName = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
				
		if(campName.contains(cmpName))
		{
			System.out.println("Campaign Created with Product");
		}
		else
		{
			System.out.println("Campaign not Created");
		}	          */
		
		//logout from application
		/*WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHover(driver, signOut);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
//		home.logOut(driver);
		
	}

}
