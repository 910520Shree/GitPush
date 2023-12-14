package practice;

import org.testng.annotations.Test;

import genericc_Utilities.BaseClass;


public class TestNG extends BaseClass{
	
	@Test(priority = -1)
	public void createProduct()
	{
		System.out.println("Product created");
	}
	
/*	@Test(groups = {"SanityTest","SmokeTest"})
	public void modifyProduct()
	{
		System.out.println("Product modified");
	}
	
	@Test(invocationCount = 2)
	public void modifyProduct1()
	{
		System.out.println("Product modified1");
	}
	
	@Test(enabled = true)
	public void deleteProduct()
	{
		System.out.println("Product deleted");
	}
*/
}
