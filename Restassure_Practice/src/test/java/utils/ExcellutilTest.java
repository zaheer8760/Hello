package utils;

public class ExcellutilTest {

	public static void main(String[] args) {
		
		String excelpath = "./data/dataTest.xlsx";
		String sheetName = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelpath, sheetName);
		excel.getRowCount();
		excel.getCellData(1,0);
	}
}
