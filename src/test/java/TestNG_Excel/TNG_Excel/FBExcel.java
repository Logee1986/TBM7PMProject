package TestNG_Excel.TNG_Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FBExcel {

	static WebDriver driver;
	
	@BeforeClass
	public static void browseropen() {
		System.setProperty("webdriver.chrome.driver", "E:\\Java_setup\\ChromeDriver_81\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	//@AfterClass
	//public static void broswerclose() {
	//	driver.quit();
	//}

	@Test
	private void A_loginpage() throws InterruptedException, IOException {
		driver.get("https:\\www.facebook.com/");
	
		File f = new File("C:\\Users\\lokesh\\eclipse-workspace\\TNG-Excel\\Excel-Data\\Facebook.xlsx");
		FileInputStream st = new FileInputStream(f);

		Thread.sleep(5000);

		Workbook wb = new XSSFWorkbook(st);
		
		Sheet st1 = wb.getSheet("Sheet1");
		
				//Firstname
				Row row = st1.getRow(0);
		
				Cell c = row.getCell(0);
				int type = c.getCellType();

				if(type == 1) {
					String name = c.getStringCellValue();
					System.out.println(name);
					WebElement fname = driver.findElement(By.id("u_0_m"));
					fname.sendKeys(name);
				}else if(type==0) {
					if(DateUtil.isCellDateFormatted(c)){
						Date date = c.getDateCellValue();
						
						SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
						String name = sf.format(date);
						System.out.println(name);
						WebElement fname = driver.findElement(By.id("u_0_m"));
						fname.sendKeys(name);
					}else {
						
						double d = c.getNumericCellValue();
						
						long ln = (long) d;
						
						String name = String.valueOf(ln);
						System.out.println(name);
						WebElement fname = driver.findElement(By.id("u_0_m"));
						fname.sendKeys(name);

					}	
				}

				//Surname
				Row row1 = st1.getRow(0);
				
				Cell c1 = row1.getCell(1);
				int type1 = c1.getCellType();

				if(type1 == 1) {
					String name = c1.getStringCellValue();
					System.out.println(name);
					WebElement sname = driver.findElement(By.id("u_0_o"));
					sname.sendKeys(name);
				}else if(type1==0) {
					if(DateUtil.isCellDateFormatted(c)){
						Date date = c1.getDateCellValue();
						
						SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
						String name = sf.format(date);
						System.out.println(name);
						WebElement sname = driver.findElement(By.id("u_0_o"));
						sname.sendKeys(name);
					}else {
						
						double d = c1.getNumericCellValue();
						
						long ln = (long) d;
						
						String name = String.valueOf(ln);
						System.out.println(name);
						WebElement sname = driver.findElement(By.id("u_0_o"));
						sname.sendKeys(name);

					}	
				}

				//Mobile number
				Row row2 = st1.getRow(0);
				
				Cell c2 = row2.getCell(2);

				double d1 = c2.getNumericCellValue();
				
				long ln = (long) d1;
				
				String name2 = String.valueOf(ln);

				WebElement mobnum = driver.findElement(By.id("u_0_r"));
				mobnum.sendKeys(name2);

				//Password
				Row row4 = st1.getRow(0);
				
				Cell c4 = row4.getCell(3);
				int type4 = c4.getCellType();

				if(type4 == 1) {
					String name = c4.getStringCellValue();
					System.out.println(name);
					WebElement pass = driver.findElement(By.id("u_0_w"));
					pass.sendKeys(name);
				}else if(type4==0) {
					if(DateUtil.isCellDateFormatted(c)){
						Date date = c4.getDateCellValue();
						
						SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
						String name = sf.format(date);
						WebElement pass = driver.findElement(By.id("u_0_w"));
						pass.sendKeys(name);
					}else {
						
						double d = c4.getNumericCellValue();
						
						long ln4 = (long) d;
						
						String name = String.valueOf(ln4);
						WebElement pass = driver.findElement(By.id("u_0_w"));
						pass.sendKeys(name);

					}	
				}
				
				//Day
				Row row3 = st1.getRow(0);
				
				Cell c3 = row3.getCell(4);

				double d3 = c3.getNumericCellValue();
				
				long ln3 = (long) d3;
				
				String name3 = String.valueOf(ln3);

				System.out.println(name3);
				WebElement date3 = driver.findElement(By.id("day"));
				date3.sendKeys(name3);

				//Month
				Row row5 = st1.getRow(0);
				
				Cell c5 = row5.getCell(5);

				String name = c5.getStringCellValue();
				System.out.println(name);
				WebElement month = driver.findElement(By.id("month"));
				month.sendKeys(name);

				//Year
				Row row6 = st1.getRow(0);
				
				Cell c6 = row6.getCell(6);

				double d6 = c6.getNumericCellValue();
				
				long ln6 = (long) d6;
				
				String name6 = String.valueOf(ln6);

				System.out.println(name6);
				WebElement year = driver.findElement(By.id("year"));
				year.sendKeys(name6);

				
				
	}
	
	
}
