package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericc_Utilities.Excel_Utility;

public class DataProviderEx2 {
	
	@Test(dataProvider = "getDataProvider")
	public void bookTickets(String src,String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest+"");
	}
	
	@DataProvider
	public Object [][] getDataProvider() throws Throwable
	{
		Excel_Utility elib = new Excel_Utility();
		Object[][] value = elib.getDataProvider("DataProv");
		return value;
	}

}
