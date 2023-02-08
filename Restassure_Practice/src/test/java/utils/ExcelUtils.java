package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelpath,String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetName);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();  
		}
	}

	public static void getRowCount() {
		
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Total num of rows"+rowCount);
		
	}
	
	public static void getCellData(int r,int c) {
		
			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue( sheet.getRow(r).getCell(c));
			
			System.out.println(value);
		
	}
	
	
}
