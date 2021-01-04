package steimatzky_search;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class search {
	static WebDriver driver;


  @BeforeClass
  public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
	//	driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
  }

  @AfterClass
  public void afterClass() {
		driver.close();

  }
  
  @Test
  public void test1() throws IOException, InterruptedException {
	  String value;
	  String path = "search - test.xlsx";
	  FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		int rows = 0;
		while (rows<=59) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(0);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			WebElement search=driver.findElement(By.id("search"));
			WebElement submit=driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			search.clear();
			search.sendKeys(value);
			submit.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains(value)) {
				System.out.println("the book "+value+" is found");
			}else {
				System.err.println("the book not "+value+" is found");
			}
			Thread.sleep(1000);	
			rows++;
		}
  }
}
