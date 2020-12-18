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
		//����� ���� ����
		FileInputStream	fis = new FileInputStream ("C:\\Users\\royko\\Documents\\��������\\excel_test.xlsx");
		//����� ������� �� �����
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//����� �������
		XSSFSheet sheet = wb.getSheet("test");	
		//����� �����
		XSSFRow	row = sheet.getRow(0);
		//����� ������
		XSSFCell cell = row.getCell(0);
		//����� ��� STRING
		String value =cell.getStringCellValue();

		//����� ��� ������
		double value1 =cell.getNumericCellValue();
		//������ ��� �����
		int value2 = (int)cell.getNumericCellValue();
		//����� ��� �������
		boolean	value3 = cell.getBooleanCellValue();
	

		//����� ����� ������� ������ ����

		 int FirstRow=  sheet.getFirstRowNum();

		 //����� ����� ������� ������ ����

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
