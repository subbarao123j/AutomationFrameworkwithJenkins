package dataProviiderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	
	public ExcelDataProvider() {
		
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File("./TestData\\TestData.xlsx")));
		} 
		 catch (IOException e) {
			
			System.out.println("Unable to read Excel data"+ e.getMessage());
		}
		
		
		
	}
	
	public String getCellData(String sheetName, int roww, int col) {
		
		XSSFCell cell = wb.getSheet(sheetName).getRow(roww).getCell(col);
		
		String data = null;
		
		if(cell.getCellTypeEnum()==CellType.STRING){
			
			 data = cell.getStringCellValue();
		
		} else if (cell.getCellTypeEnum()==CellType.NUMERIC) {
			 data = String.valueOf((int)cell.getNumericCellValue());
			
			
		} else if (cell.getCellTypeEnum()==CellType.BLANK) {
			
			data ="";
			
			
			
		}
		
		return data;
		
		
		
	}
	
	
	public int getRows(String sheetName) {
		
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
		
	}


}
