package pomRepositoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationHOmePage {
	
	//Initialization
		public OrganizationHOmePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement organizationPlus;

		//getter method
		public WebElement getOrganizationPlus() {
			return organizationPlus;
		}
		
		//Business logics
		//This method is used to click on Campaign(+)Sign
		public void clickOrganizationPlus()
		{
			organizationPlus.click();
		}

}
