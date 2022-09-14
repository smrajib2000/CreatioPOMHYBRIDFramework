package com.qa.creatio.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = "E:\\Eclipse with project\\API TESTING\\CreatioByLocatorPOM\\"
												+ "src\\main\\java\\com\\qa\\creatio\\appTestData\\appTestData.xlsx";
	public static Object[][] getTestDataFromExcel(String sheetName) {
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory .create(file);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i<sheet.getLastRowNum();i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		return data;
	}

}
