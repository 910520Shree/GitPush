package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static void main(String[] args) throws Throwable {
		
		//without webdrivermanager
		//WebDriver driver = new EdgeDriver();
		//ctrl+shift+o for importing everything at once
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		//path setup
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesFile.properties.txt");
		
		//loading the file to properties class
		Properties pro = new Properties();
		pro.load(fis);
		
		//fetching key from properties class
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//driver.get("https://www.saucedemo.com/v1/");
		driver.get(URL);
		
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		
		driver.findElement(By.id("login-button")).click();
		

	}

}
