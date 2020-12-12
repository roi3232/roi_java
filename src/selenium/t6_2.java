package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class t6_2 {
	static WebDriver driver;
	
	public static void excelPrint(String filePath, String value, int rowNumber, int cellNumber) {
		   try {
			   FileInputStream inputStream = new FileInputStream(new File(filePath));
			   Workbook workbook = WorkbookFactory.create(inputStream);
			   Sheet sheet = workbook.getSheetAt(0);
			   Row r = sheet.getRow(rowNumber);
			   if (r == null) {
				   r = sheet.createRow(rowNumber);
				   }
			   Cell c = r.getCell(cellNumber);
			   if (c == null) {
				   c=r.createCell(cellNumber);
				   }
			   c.setCellValue(value);
			   FileOutputStream outputStream = new FileOutputStream(filePath);
			   workbook.write(outputStream);
			   workbook.close();
			   outputStream.close();
			   } catch (Exception ex) {
				   ex.printStackTrace();
				   }
		   }

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//תרגיל 1
		try {
			String path = "C:\\Users\\royko\\Documents\\אוטומציה\\excel_test.xlsx";
			String value;	 
			String titlegoogle = null;
			FileInputStream fis3 = new  FileInputStream (path);
			XSSFWorkbook wb = new XSSFWorkbook (fis3);
			XSSFSheet sheet = wb.getSheet("test");
			int rows = 0;
			System.setProperty("webdriver.chrome.driver","C:\\temp\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");  
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.co.il/#q=%D7%9E%D7%A9%D7%94%D7%95");
			Thread.sleep(1000);
			while (rows<=10) {
				try {
					XSSFRow row_r = sheet.getRow(rows);
					XSSFCell cell_r = row_r.getCell(0);
					value = cell_r.getStringCellValue();
					Thread.sleep(500);
					driver.findElement(By.name("q")).clear();
					driver.findElement(By.name("q")).sendKeys(value);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/button")).click();
					Thread.sleep(2000);
					titlegoogle = driver.findElements(By.xpath("//div[@class='g'][1]//h3[1]")).get(0).getText();
					} catch (Exception e) {
						System.err.println("הקריאה נכשלה");
						}
				excelPrint(path,titlegoogle, rows,1);
				rows++;
				}
			driver.close();
			} catch (Exception e) {
				}
//תרגיל 2
		try {
			int clom=2;
			String path = "C:\\Users\\royko\\Documents\\אוטומציה\\excel_test2.xlsx";
			System.setProperty("webdriver.chrome.driver","C:\\temp\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");  
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://danielauto.net/practice/loginPage/loginpageTest.html");
			WebElement username=driver.findElement(By.id("uaertName"));
			WebElement password =driver.findElement(By.id("password"));
			WebElement button = driver.findElement(By.id("send"));
			WebElement err = driver.findElement(By.id("err"));
			try {
				username.sendKeys("admin");
				password.sendKeys("12345");
				button.click();
		
				if (err.getText().equals("You have entered incorrect details")) {
					excelPrint(path,"עבר",1,clom);
					
				} else {
					excelPrint(path,"לא עבר",1,clom);
				}
			} catch (Exception e) {
			}
			try {
				username.sendKeys("admin");
				password.sendKeys("pass");
				button.click();
		
				if (err.getText().equals("You have entered incorrect details")) {
					excelPrint(path,"עבר",2,clom);
				} else {
					excelPrint(path,"לא עבר",2,clom);
				}
			} catch (Exception e) {
			}
			
			try {
				driver.get("http://danielauto.net/practice/loginPage/loginpageTest.html");
				username = driver.findElement(By.id("uaertName"));
				password = driver.findElement(By.id("password"));
				button = driver.findElement(By.xpath("/html/body/button"));
				err = driver.findElement(By.id("err"));
				username.sendKeys("admin");
				password.sendKeys("");
				button.click();
		
				if (err.getText().equals("You have entered incorrect details")) {
					excelPrint(path,"עבר",3,clom);
				} else {
					excelPrint(path,"לא עבר",3,clom);
				}
			} catch (Exception e) {
				excelPrint(path,"לא עבר",3,clom);
			}
			try {
				driver.get("http://danielauto.net/practice/loginPage/loginpageTest.html");
				username = driver.findElement(By.id("uaertName"));
				password = driver.findElement(By.id("password"));
				button = driver.findElement(By.xpath("/html/body/button"));
				err = driver.findElement(By.id("err"));
				username.sendKeys("admin");
				password.sendKeys("admin");
				button.click();
				if (driver.findElement(By.tagName("h1")).getText().equals("You've logged in successfully")) {
					excelPrint(path,"עבר", 4,clom);
				} else {
					excelPrint(path,"לא עבר",4,clom);
				}
			} catch (Exception e) {
				excelPrint(path,"לא עבר",4,clom);
			}
			driver.close();
		} catch (Exception e) {
		}
//תרגיל 3
		try {
			String path = "C:\\Users\\royko\\Documents\\אוטומציה\\excel_test3.xlsx";
			System.setProperty("webdriver.chrome.driver","C:\\temp\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true"); 
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.b144.co.il/clients/%D7%90/");
			List<WebElement> charsList = driver.findElements(By.xpath("//form/div[4]/main/div/div/div[1]/div/a"));
		for (int i = 1; i <=charsList.size(); i++) {
			charsList = driver.findElements(By.xpath("//div[@id='baseMasterContent_Content_Letters_PnlControl']//a"));	
			List<WebElement> list = driver.findElements(By.xpath("//li[@class='m-container-nero']"));
				for (int j = 0; j <= 10; j++) {		
				String links = list.get(j).getText();
				excelPrint(path,links, j , i);
				}				
				charsList.get(i).click();
				}
		} catch (Exception e) {
		}
		driver.close();
		//
		}
	//
	}
