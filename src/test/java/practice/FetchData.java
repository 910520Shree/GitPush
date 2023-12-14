package practice;


import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchData {

	public static void main(String[] args) throws Throwable {
		
        FileInputStream fes = new FileInputStream("./src/test/resources/BookSelenium.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("FirstPage");
		
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(2);
		
		/*String data = cel.toString();
	    System.out.println(data);*/
		
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cel);
		System.out.println(data);

	}

}
