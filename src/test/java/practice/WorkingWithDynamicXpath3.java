package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDynamicXpath3 {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hindustantimes.com/");
		
		driver.switchTo().frame("webpush-onsite");
		driver.findElement(By.id("deny")).click();
		driver.switchTo().defaultContent();
		
		String s =driver.findElement(By.xpath("//div[@id='topnews']//h2[@class='hdg3']/a")).getText();
		System.out.println(s);
		
		driver.close();
					
	}

}
