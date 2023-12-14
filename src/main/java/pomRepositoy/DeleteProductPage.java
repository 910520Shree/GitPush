package pomRepositoy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericc_Utilities.WebDriver_Utility;

public class DeleteProductPage {
	
	//Initialization
	public DeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement navigateProductTable;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteProduct;
	
	//getter methods

	public WebElement getNavigateProductTable() {
		return navigateProductTable;
	}

	public WebElement getDeleteProduct() {
		return deleteProduct;
	}
	
	//Business logics
	public void productTable()
	{
		navigateProductTable.click();
	}
	public void deletePrdData(WebDriver driver,WebDriver_Utility wlib)
	{
		deleteProduct.click();
		wlib.alterOk(driver);
	}
	
	public void validateProduct(WebDriver driver,String productName)
	{
		List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		boolean flag = false;
		
		for(WebElement prd:prdList)
		{
			String actData=prd.getText();
			if(actData.contains(productName))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Product not deleted");
		}
	}

}
