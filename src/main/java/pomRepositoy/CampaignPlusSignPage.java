package pomRepositoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPlusSignPage {
	
	//Initialization
	public CampaignPlusSignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement campaignPlus;

	//getter method
	public WebElement getCampaignPlus() {
		return campaignPlus;
	}
	
	//Business logics
	//This method is used to click on Campaign(+)Sign
	public void clickCampaignPlus()
	{
		campaignPlus.click();
	}

}
