package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	//constructor
	public ExcelUtils(String excelFilePath,String sheetName) {
		
		XSSFWorkbook workbook;
		try {
			
			workbook = new XSSFWorkbook(excelFilePath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static int getRowCount() {	
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("number of rows are: "+rowcount);
		return rowcount;
	}
	
	
	public static Object getCellData(int rowNum,int columnNum) {	
//			String value = sheet.getRow(1).getCell(0).getStringCellValue();
//			double value = sheet.getRow(1).getCell(0).getNumericCellValue(); // for numeric values
			
			DataFormatter formatter  = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(columnNum)); // can get any type of data
			System.out.println("value is "+ value);
			return value;
		}

}
