package practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDataToProperties_File {

	public static void main(String[] args) throws Throwable {
		
		Properties pro = new Properties();
		pro.setProperty("username", "standard_user");
		pro.setProperty("password", "secret_sauce");
		pro.setProperty("url", "https://www.saucedemo.com/v1/");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/PropertiesFile.properties.txt");
		pro.store(fos, "COMMONDATA");
		System.out.println("Data written successfully");

	}

}
