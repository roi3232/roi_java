package excel_csv;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class t6 {


	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver=new ChromeDriver();
		//מיקום קובץ אקסל
		FileInputStream	fis = new FileInputStream ("C:\\Users\\royko\\Documents\\אוטומציה\\excel_test.xlsx");
		//יצירת אובייקט עם בקובץ
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//פנייה לגיליון
		XSSFSheet sheet = wb.getSheet("test");	
		//פנייה לשורה
		XSSFRow	row = sheet.getRow(0);
		//פנייה לעמודה
		XSSFCell cell = row.getCell(0);
		//לקחית ערת STRING
		String value =cell.getStringCellValue();

		//לקיחת ערך עשרוני
		double value1 =cell.getNumericCellValue();
		//לקיתחת ערך מספרי
		int value2 = (int)cell.getNumericCellValue();
		//לקיחת ערך בוליאני
		boolean	value3 = cell.getBooleanCellValue();
	

		//לקיחת השורה הראשונה המכילה טקסט

		 int FirstRow=  sheet.getFirstRowNum();

		 //לקיחת השורה האחרונה המכילה טקסט

		int LastRow=  sheet.getLastRowNum();          

		for (int i = FirstRow; i <= LastRow; i++) {

		XSSFRow row_r = sheet.getRow(i);

		XSSFCell cell_r = row_r.getCell(1);

		String value4 = cell_r.getStringCellValue();

		System.out.println(value4);
		}

		                 
		
		
	//	
	}
//
}
