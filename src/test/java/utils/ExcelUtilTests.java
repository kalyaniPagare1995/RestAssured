package utils;

public class ExcelUtilTests {
	
	public static void main(String[] args) {
		String excelFilepth = "./data/DataForPost.xlsx";
		String sheetName = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelFilepth,sheetName );
	 excel.getRowCount();
	 excel.getCellData(1, 0);
	 excel.getCellData(1, 1);

	}
}
