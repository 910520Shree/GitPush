package genericc_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/BookSelenium.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String excelData = cel.getStringCellValue();
		return excelData;
	}
	
	public String getDataFormatterData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/BookSelenium.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String excelData = format.formatCellValue(cel);
		return excelData;
	}
	
	public Object[][] getDataProvider(String sheetName) throws Throwable
	{
		FileInputStream fes = new FileInputStream("C:/Users/Anil/Desktop/DataProv.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		short lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	public Object[][] getMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fes = new FileInputStream("C:/Users/Anil/Desktop/DataProv.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		short lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj;
	}

}
