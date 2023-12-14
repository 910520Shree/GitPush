package pomRepositoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	//Initialization
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name="campaignname")
	private WebElement createCampaign;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveCampButton;

	//getter method
	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getSaveCampButton() {
		return saveCampButton;
	}
	
	//Business Logics
	//This method is used to enter camp name
	public void campaignName(String name)
	{
		createCampaign.sendKeys(name);
		saveCampButton.click();
	}
	
	//This method is used to click on save camp
	/*public void clickOnCampSave()
	{
		saveCampButton.click();
	}*/
			

}
