package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
        FileInputStream fes = new FileInputStream("./src/test/resources/BookSelenium.xlsx");
		
		Workbook book = WorkbookFactory.create(fes);
		
		Sheet sheet = book.getSheet("Sheet1");
		
		int rCount = sheet.getLastRowNum();
		System.out.println(rCount);
		
		for(int i=0;i<rCount;i++) 
		{
			Row row = sheet.getRow(i);
			short celCount = row.getLastCellNum();
			//System.out.println(celCount);
			
			for(int j=0;j<celCount;j++)
			{
			Cell cel = row.getCell(j);
			//String excelData = cel.getStringCellValue();
			DataFormatter format = new DataFormatter();
			String data = format.formatCellValue(cel);
			System.out.println(data);
			}
		}	

	}
}
