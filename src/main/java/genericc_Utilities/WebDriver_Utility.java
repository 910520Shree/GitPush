package genericc_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	/**
	 * This method is used to maximize the window
	 */
	public void maximizingWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the window
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait elements to get loaded in GUI
	 */
	public void implicit_Wait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method is used for switching windows
	 * @param driver
	 * @param ele
	 */
	public void windowSwitching(WebDriver driver,String partialVisibleText)
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		
		while(window.hasNext())
		{
			String win = window.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			
		if(title.contains(partialVisibleText))
		{
			break;

		}
		}
	}
	// 1.Mouse Hovering
	public void mouseHover(WebDriver driver,WebElement ele ) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	// 2.Double clicking
	public void doubleClick(WebDriver driver,WebElement ele ) {
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();
	}
		
	// 3.Right click
	public void rightClick(WebDriver driver,WebElement ele ) {
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
	}
		
	// 4.Drag and Drop
	public void dragAndDrop(WebDriver driver,WebElement ele1,WebElement ele2 ) {
		Actions a = new Actions(driver);
		a.dragAndDrop(ele1,ele2).perform();
	}
		
	// 5.Handling alter pop up, clicking on ok
	public void alterOk(WebDriver driver) {
					
		driver.switchTo().alert().accept();
	}
				
	// 6.Handling alter pop up, clicking on cancel
	public void alteCancel(WebDriver driver) {
					
		driver.switchTo().alert().dismiss();
	}
	
	//7.Child browser
	public void childBrowser(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String b:child) {
			driver.switchTo().window(b);
		}
	}
	
	//8.Parent browser
	public void parentBrowser(WebDriver driver) {
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
	}
	
	//9.Single drop down by using index
	public void singleDp_index(WebElement dD,int indNum) {
		Select s= new Select(dD);
		s.selectByIndex(indNum);
	}
	//10.Single drop down by using value
	public void singleDp_value(WebElement dD,String value) {
		Select s= new Select(dD);
		s.selectByValue(value);
	}
	//11.Single drop down by using visible text
	public void singleDp_visibleText(WebElement dD,String value) {
		Select s= new Select(dD);
		s.selectByVisibleText(value);
	}

}
