package pomRepositoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericc_Utilities.WebDriver_Utility;

public class HomePage {
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	//Campaign
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	//organization
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	//Logout
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminSign;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOut;
	
	//Product
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	//getter Methods

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	public WebElement getAdminSign() {
		return adminSign;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	public WebElement getProductLink() {
		return productLink;
	}
	
	//Business Logics

	public void clickOnMoreLink()
	{
		moreLink.click();}
	
	public void clickOnCampaignsLink()
	{
		campaignsLink.click();
	}
	
	//this method is used to click on both more and campaigns
	WebDriver_Utility wlib = new WebDriver_Utility();
	public void mouseHoverOnMoreLink(WebDriver driver)
	{
		wlib.mouseHover(driver, moreLink);
		campaignsLink.click();
	}
	
	public void clickOnOrganizationLink()
	{
		organizationLink.click();
	}
	
	//This method is used to logout from the application
	public void logOut(WebDriver driver)
	{
		wlib.mouseHover(driver, adminSign);
		signOut.click();
	}
	
	public void clickOnProductLink()
	{
		productLink.click();
	}

}
