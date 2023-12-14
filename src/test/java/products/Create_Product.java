package products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericc_Utilities.BaseClass;
import genericc_Utilities.Excel_Utility;
import genericc_Utilities.File_Utility;
import genericc_Utilities.Java_Utility;
import genericc_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepositoy.CreateProductPage;
import pomRepositoy.HomePage;
import pomRepositoy.LoginPage;
import pomRepositoy.ProductHomePage;
import pomRepositoy.ValidationPage;

public class Create_Product extends BaseClass{

	@Test(retryAnalyzer = genericc_Utilities.RetryImplementation.class)
//	public static void main(String[] args) throws Throwable {
	public void Create_ProductTest() throws Throwable {
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
		
		//login to Vtiger application
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
		String prdname = elib.getDataFormatterData("product", 0, 0)+ranNum;
//		driver.findElement(By.name("productname")).sendKeys(prdname);
		CreateProductPage plus = new CreateProductPage(driver);
		System.out.println(prdname);
						
		//click on save button  
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		plus.productNameSave(prdname);
						
		//validate product name is created
		ValidationPage prdVal = new ValidationPage(driver);
		String actDta = prdVal.prdValidate();
		Assert.assertEquals(false, true);
		Assert.assertEquals(actDta, prdname);	/*	Thread.sleep(2000);
		String prodName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
						
		if(prodName.contains(prdname))
		{
			System.out.println("Product Created");
		}
		else
		{
			System.out.println("Product not Created");
		}      */
		
		//logout from application
		/*Thread.sleep(2000);	
		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions a = new Actions(driver);
//		a.moveToElement(signOut).perform();
		wlib.mouseHover(driver, signOut);
		driver.findElement(By.linkText("Sign Out")).click();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//*-->replaces tag name, .-->replaces text() function---use only 1 out of 1*/
//		home.logOut(driver);

	}

}
