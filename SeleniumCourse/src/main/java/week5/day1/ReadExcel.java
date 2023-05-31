package week5.day1;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel  {

	public String[][] readData(String filename ,String Sheetname) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./Data/"+filename+".xlsx");
		int numberOfSheets = wb.getNumberOfSheets();
		System.out.println(numberOfSheets);
		 
		XSSFSheet ws = wb.getSheet(Sheetname);
		
		int rowCount = ws.getLastRowNum();
		System.out.println(rowCount);
	int CellCount = ws.getRow(0).getLastCellNum();
	System.out.println(CellCount);
	String[][] data = new String[rowCount][CellCount];
	
	for(int sheet=1;sheet<=numberOfSheets;sheet++) {
		
	
		for (int i = 1; i<= rowCount;i++) {
			
			for( int j=0;j<CellCount;j++) {
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j]= text;
				
			}
		} }
	wb.close();
		return data;

	
	}

}
