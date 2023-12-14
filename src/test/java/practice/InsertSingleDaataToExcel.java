package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDaataToExcel {

	public static void main(String[] args) throws Throwable {
		
		//Step1:Set the path
		FileInputStream fes = new FileInputStream("./src/test/resources/BookSelenium.xlsx");
				
		//Step2:Open WorkBook in read mode
		Workbook book = WorkbookFactory.create(fes);
				
		//Step3:get control to the sheet
		Sheet sheet = book.getSheet("FirstPage");
		
		Row row = sheet.createRow(6);
		
		Cell cel1 = row.createCell(0);
		
		cel1.setCellValue("Qspiders");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/BookSelenium.xlsx");
		book.write(fos);
		book.close();

	}

}
