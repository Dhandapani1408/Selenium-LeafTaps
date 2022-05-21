package com.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {

	public static Object[][] readExcelData(String excelfileName,String sheetName) throws Exception {
		XSSFWorkbook wbook = 
				new XSSFWorkbook("./data/"+excelfileName+".xlsx");
		XSSFSheet sheet = wbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
//		System.out.println("Row Count is: "+rowCount);
		int colCount = sheet.getRow(0).getLastCellNum();
//		System.out.println("Col Count is: "+colCount);
		Object[][] data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				data[i-1][j] = stringCellValue;
//				System.out.println(stringCellValue);
			} 
		}
		wbook.close();
		return data;
	}
}
