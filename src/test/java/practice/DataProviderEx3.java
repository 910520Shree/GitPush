package practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericc_Utilities.Excel_Utility;
import genericc_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx3{
	
	@Test(dataProvider = "getData")
	public void createOrganization(String orgname,String phone,String email)
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8888/");
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname+ranNum);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebDriver_Utility wlib = new WebDriver_Utility();
		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHover(driver, signOut);
		driver.quit();
	}
	
	@DataProvider
	public Object [][] getData() throws Throwable
	{
		Excel_Utility elib = new Excel_Utility();
		Object[][] value = elib.getMultipleData("Sheet1");
		return value;
		
	/*	Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		Object[][] obj = new Object[3][3];
		
		obj[0][0]="AAA"+ranNum;
		obj[0][1]="9348982758";
		obj[0][2]="ksfn@gmail.com";
		
		obj[1][0]="BBB"+ranNum;
		obj[1][1]="09989848432";
		obj[1][2]="oiuiu@gmail.com";
		
		obj[2][0]="CCC"+ranNum;
		obj[2][1]="456789789";
		obj[2][2]="mnbnb@gmail.com";
		
		return obj;   */
	}

}
