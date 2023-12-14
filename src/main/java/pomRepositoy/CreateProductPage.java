package pomRepositoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	//Initialization
		public CreateProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(name="productname")
		private WebElement createProduct;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveProdButton;

		//getter method
		public WebElement getCreateProduct() {
			return createProduct;
		}

		public WebElement getSaveProdButton() {
			return saveProdButton;
		}
		
		//Business Logics
		//This method is used to enter camp name
		public void productNameSave(String name)
		{
			createProduct.sendKeys(name);
			saveProdButton.click();
		}
		
		//This method is used to click on save camp
	/*	public void clickOnProdSave()
		{
			saveProdButton.click();
		}*/

}
