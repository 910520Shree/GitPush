package pomRepositoy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericc_Utilities.WebDriver_Utility;

public class ProductWindowPage {
	
	//Initialization
	public ProductWindowPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath ="//img[@alt='Select']")
	private WebElement selectPlusSign;
	
	@FindBy(name ="search_text")
	private WebElement productTextBox;
	
	@FindBy(name = "search")
	private WebElement productSearchButton;
	
	//getter methods

	public WebElement getSelectPlusSign() {
		return selectPlusSign;
	}

	public WebElement getProductTextBox() {
		return productTextBox;
	}

	public WebElement getProductSearchButton() {
		return productSearchButton;
	}
	
	//Business logics
	public void clickOnPrdPlusSign(WebDriver driver,WebDriver_Utility wlib)
	{
		selectPlusSign.click();
		wlib.windowSwitching(driver, "Products&action");
	}
	
	public void productNameSearch(String prdName)
	{
		productTextBox.sendKeys(prdName);
		productSearchButton.click();
	}
	
	public void selectProduct(WebDriver driver, WebDriver_Utility wlib, String prdName)
	{
		driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
		wlib.windowSwitching(driver, "Campaigns&action");
	}

}
