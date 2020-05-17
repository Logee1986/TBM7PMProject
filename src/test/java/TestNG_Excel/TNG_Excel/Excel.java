package TestNG_Excel.TNG_Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class Excel {
	
	@Test
	public void Excel1() throws IOException {
		
	//public static void main(String args[]) throws IOException {
		File f = new File("C:\\Users\\lokesh\\eclipse-workspace\\TNG-Excel\\Excel-Data\\Facebook.xlsx");
		FileInputStream st = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(st);
		
		Sheet st1 = wb.getSheet("Sheet1");
		
		for (int i=0; i<st1.getPhysicalNumberOfRows(); i++) {
			Row row = st1.getRow(i);
			for (int j=0; j<row.getPhysicalNumberOfCells(); j++) {
				Cell c = row.getCell(j);
				int type = c.getCellType();
				
				if(type == 1) {
					String name = c.getStringCellValue();
					System.out.println(name);
				}else if(type==0) {
					if(DateUtil.isCellDateFormatted(c)){
						Date date = c.getDateCellValue();
						
						SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
						String name = sf.format(date);
						System.out.println(name);
					}else {
						
						double d = c.getNumericCellValue();
						
						long ln = (long) d;
						
						String name = String.valueOf(ln);
						System.out.println(name);	
					}	
				}	
			}	
		}
	}
}
