package pomRepositoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {
	
	//Initialization
	public ValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//Declaration
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement validateCampaign;
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement validateOrganization;
	
	@FindBy(xpath ="//span[@id='dtlview_Product Name']")
	private WebElement validateProduct;
	
	//getter method
	
	public WebElement getValidateCampaign() {
		return validateCampaign;
	}
	
	public WebElement getValidateOrganization() {
		return validateOrganization;
	}

	public WebElement getValidateProduct() {
		return validateProduct;
	}

	//Business logics
	public String campValidate()
	{
		return validateCampaign.getText();
//		if(actData.contains(campname))
//		{
//			System.out.println("Campaign Created");
//		}
//		else
//		{
//			System.out.println("Campaign not Created");
//		}
	}
	
	public String orgValidate()
	{
		return validateOrganization.getText();
//		if(actData.contains(orgname))
//		{
//			System.out.println("Organization Created");
//		}
//		else
//		{
//			System.out.println("Organization not Created");
//		}
	}
	
	public String prdValidate()
	{
		return validateProduct.getText();
//		if(actData.contains(prdname))
//		{
//			System.out.println("Product Created");
//		}
//		else
//		{
//			System.out.println("Product not Created");
//		}
	}
		
}
