package steimatzky_search;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
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
	static String value;
	static String path = "search - test.xlsx";
	static int rows;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();

	}

	@SuppressWarnings("resource")
	@Test(priority = 1)
	public void books() throws IOException, InterruptedException {
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 58) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(0);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			WebElement search = driver.findElement(By.id("search"));
			WebElement submit = driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			search.clear();
			search.sendKeys(value);
			submit.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains(value)) {
				System.out.println("the book " + value + " is found");
			} else {
				System.err.println("the book not " + value + " is found");
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 2)
	public void ebooks() throws IOException, InterruptedException {
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 11) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(1);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			WebElement search = driver.findElement(By.id("search"));
			WebElement submit = driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			search.clear();
			search.sendKeys(value);
			submit.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains(value)) {
				System.out.println("the book " + value + " is found");
			} else {
				System.err.println("the book not " + value + " is found");
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 3)
	public void gift() throws IOException, InterruptedException {
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 5) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(2);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			WebElement search = driver.findElement(By.id("search"));
			WebElement submit = driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			search.clear();
			search.sendKeys(value);
			submit.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains(value)) {
				System.out.println("the product " + value + " is found");
			} else {
				System.err.println("the product not " + value + " is found");
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 3)
	public void games() throws IOException, InterruptedException {
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 13) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(3);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			WebElement search = driver.findElement(By.id("search"));
			WebElement submit = driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			search.clear();
			search.sendKeys(value);
			submit.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains(value)) {
				System.out.println("the product " + value + " is found");
			} else {
				System.err.println("the product not " + value + " is found");
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 4)
	public void music() throws IOException, InterruptedException {
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 6) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(4);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			WebElement search = driver.findElement(By.id("search"));
			WebElement submit = driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			search.clear();
			search.sendKeys(value);
			submit.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains(value)) {
				System.out.println("the product " + value + " is found");
			} else {
				System.err.println("the product not " + value + " is found");
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 5)
	public void ele() throws IOException, InterruptedException {
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 10) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(5);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			WebElement search = driver.findElement(By.id("search"));
			WebElement submit = driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			search.clear();
			search.sendKeys(value);
			submit.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains(value)) {
				System.out.println("the product " + value + " is found");
			} else {
				System.err.println("the product not " + value + " is found");
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 6)
	public void cos() throws IOException, InterruptedException {
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 5) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(6);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			WebElement search = driver.findElement(By.id("search"));
			WebElement submit = driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			search.clear();
			search.sendKeys(value);
			submit.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains(value)) {
				System.out.println("the product " + value + " is found");
			} else {
				System.err.println("the product not " + value + " is found");
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 7)
	public void home() throws IOException, InterruptedException {
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 11) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(7);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			WebElement search = driver.findElement(By.id("search"));
			WebElement submit = driver.findElement(By.xpath("//form[@id='search_mini_form']/input[2]"));
			search.clear();
			search.sendKeys(value);
			submit.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains(value)) {
				System.out.println("the product " + value + " is found");
			} else {
				System.err.println("the product not " + value + " is found");
			}
			Thread.sleep(1000);
			rows++;
		}
	}
}
