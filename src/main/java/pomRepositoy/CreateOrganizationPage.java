package pomRepositoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	//Initialization
		public CreateOrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(name="accountname")
		private WebElement createOrganization;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveOrgButton;
		
		@FindBy(name ="phone")
		private WebElement phoneNumber;
		
		@FindBy(name="email1")
		private WebElement emailAddress; 

		//getter method
		public WebElement getCreateOrganization() {
			return createOrganization;
		}

		public WebElement getSaveOrgButton() {
			return saveOrgButton;
		}
		
		public WebElement getPhoneNumber() {
			return phoneNumber;
		}

		public WebElement getEmailAdress() {
			return emailAddress;
		}

		//Business Logics
		//This method is used to enter camp name
		public void orgNameSave(String name,String phone,String email)
		{
			createOrganization.sendKeys(name);
			phoneNumber.sendKeys(phone);
			emailAddress.sendKeys(email);
			saveOrgButton.click();
		}
		
		//This method is used to click on save camp
	/*	public void clickOnCampSave()
		{
			saveCampButton.click();
		}*/

}
