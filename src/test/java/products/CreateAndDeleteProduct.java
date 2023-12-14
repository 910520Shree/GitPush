package products;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericc_Utilities.BaseClass;
import genericc_Utilities.Excel_Utility;
import genericc_Utilities.File_Utility;
import genericc_Utilities.Java_Utility;
import genericc_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepositoy.CreateProductPage;
import pomRepositoy.DeleteProductPage;
import pomRepositoy.HomePage;
import pomRepositoy.LoginPage;
import pomRepositoy.ProductHomePage;
import pomRepositoy.ValidationPage;

public class CreateAndDeleteProduct extends BaseClass{

	@Test
//	public static void main(String[] args) throws Throwable {
	public void CreateAndDeleteProductTest() throws Throwable {
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
		System.out.println(prdname);
//		driver.findElement(By.name("productname")).sendKeys(prdname);
		CreateProductPage plus = new CreateProductPage(driver);
		plus.productNameSave(prdname);
								
		//click on save button  
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
								
		//validate product name is created
		ValidationPage prdVal = new ValidationPage(driver);
		String actDta = prdVal.prdValidate();
		Assert.assertEquals(actDta, prdname);	/*	Thread.sleep(2000);
		String prodName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
								
		if(prodName.contains(prdname))
		{
			System.out.println("Product Created");
		}
		else
		{
			System.out.println("Product not Created");
		}            */
		
		DeleteProductPage deletePrd = new DeleteProductPage(driver);
		deletePrd.productTable();
		//driver.findElement(By.linkText("Products")).click();
	//	home.clickOnProductLink();
		driver.findElement(By.xpath("//a[text()='"+prdname+"']/../preceding-sibling::td/input")).click();
		/*driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(prdname);
		WebElement dd = driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
		Select s= new Select(dd);
		s.selectByVisibleText("Product Name");
		driver.findElement(By.xpath("(//input[@class='crmbutton small create'])[1]")).click();
		
		driver.findElement(By.name("selected_id")).click();*/
	//	driver.findElement(By.xpath("//input[@value='Delete']")).click();
		deletePrd.deletePrdData(driver,wlib);
		
		//switching the control
	//	wlib.alterOk(driver);
//		Alert al = driver.switchTo().alert();
//		al.accept();
		
		//validation
		deletePrd.validateProduct(driver, prdname);
//		List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
//		boolean flag = false;
//		
//		for(WebElement prd:prdList)
//		{
//			String actData=prd.getText();
//			if(actData.contains(prdname))
//			{
//				flag=true;
//				break;
//			}
//		}
//		if(flag)
//		{
//			System.out.println("Product deleted");
//		}
//		else
//		{
//			System.out.println("Product not deleted");
//		}
//				
		//logout from application
		/*Thread.sleep(2000);	
		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHover(driver, signOut);
		driver.findElement(By.linkText("Sign Out")).click();
//		Actions a = new Actions(driver);
//		a.moveToElement(signOut).perform();
//		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//*-->replaces tag name, .-->replaces text() function---use only 1 out of 1*/
//		home.logOut(driver);

	}
}
