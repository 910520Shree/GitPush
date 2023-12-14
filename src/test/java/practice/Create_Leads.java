package practice;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Leads {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		String lname = "Gowda"+ranNum;
		String compName = "QSP";
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("company")).sendKeys(compName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		String lastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		String companyName = driver.findElement(By.xpath("//span[@id='dtlview_Company']")).getText();
		
		if(lastName.contains(lname) && companyName.contains(compName))
		{
			System.out.println("Leads Created");
		}
		else
		{
			System.out.println("Leads not Created");
		}
		
		Thread.sleep(2000);	
		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(signOut).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//*-->replaces tag name, .-->replaces text() function---use only 1 out of 1

	}

}
