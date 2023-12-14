package practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.edge.EdgeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadDataFromJson {

	public static void main(String[] args) throws Throwable {
		
		File fs = new File("./src/test/resources/Jason.json");
		
		ObjectMapper object = new ObjectMapper();
		JsonNode jsonData = object.readTree(fs);
		
		String uRL = jsonData.get("url").asText();
		String userName = jsonData.get("username").asText();
		
		EdgeDriver driver = new EdgeDriver();
		
		driver.get(uRL);

	}

}
