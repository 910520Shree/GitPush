package genericc_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	/*
	 * This method is used to fetch common data in application
	 * @author Shobha
	 */
	
	public String getKeyAndValueData(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Generic.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}

}
