package pomRepositoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductHomePage {
	
	//Initialization
		public ProductHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(xpath="//img[@alt='Create Product...']")
		private WebElement productPlus;

		//getter method
		public WebElement getProductPlus() {
			return productPlus;
		}
		
		//Business logics
		//This method is used to click on Campaign(+)Sign
		public void clickProductPlus()
		{
			productPlus.click();
		}

}
