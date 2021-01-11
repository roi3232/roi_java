package test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.io.FileInputStream;
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
	@SuppressWarnings("resource")
	public String Product_value(int rows, int cell, String sheets) throws IOException {
		FileInputStream fis3 = new FileInputStream("search - test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet(sheets);
		XSSFRow row_r = sheet.getRow(rows);
		XSSFCell cell_r = row_r.getCell(cell);
		String value = cell_r.getStringCellValue();
		return value;
	}

	public static WebDriver driver;
	static String sheet = "text_search";

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();

	}

	@Test(priority = 1, enabled = true)
	public void clean_search_field() throws IOException, InterruptedException, AWTException {
		int rows = 0;
		while (rows <= 30) {
			WebElement search = driver.findElement(By.id("search"));
			WebElement submit = driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			// read from excel file
			String value = Product_value(rows, 0, "Product_search");
			Thread.sleep(500);
			// search the value
			search.sendKeys(value);
			submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement search2 = driver.findElement(By.id("search"));
			String search1 = search2.getAttribute("value");
			// test if search field is clear
			try {

				if (search1.equals("מה תרצו לקנות היום?")) {
					System.out.println("test pass");
				} else {
					System.err.println("test fail");
				}
			} catch (Exception e) {
				// if don't find product
				if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText()
						.contains("אין תוצאות לשאילתת חיפוש שלך")) {
					search.clear();
				}
			}
			Thread.sleep(1000);
			rows++;
		}
	}
}
