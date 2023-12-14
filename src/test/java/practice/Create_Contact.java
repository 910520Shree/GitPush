package practice;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Contact {

	@Test
	public void Create_ContactTest() throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		String fname = "Shwetha"+ranNum;
		String lname = "Shree";
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		Thread.sleep(2000);
		String firstName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
		String lastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		
		if(firstName.contains(fname) && lastName.contains(lname))
		{
			System.out.println("Contact Created");
		}
		else
		{
			System.out.println("Contact not Created");
		}
		
		Thread.sleep(2000);	
		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(signOut).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//*-->replaces tag name, .-->replaces text() function---use only 1 out of 1

	}
	
	@Test
	public void createProduct()
	{
		System.out.println("Product created");
	}

}
