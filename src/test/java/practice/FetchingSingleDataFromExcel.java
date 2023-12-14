package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		//Step1:Set the path
		FileInputStream fes = new FileInputStream("./src/test/resources/BookSelenium.xlsx");
		
		//Step2:Open WorkBook in read mode
		Workbook book = WorkbookFactory.create(fes);
		
		//Step3:get control to the sheet
		Sheet sheet = book.getSheet("FirstPage");
		
		//Step4:get control on row
		Row row = sheet.getRow(2);
		
		//Step5:get control on cell
		Cell cel = row.getCell(1);
		
		String excelData = cel.getStringCellValue();
		
		System.out.println(excelData);
		

	}

}
