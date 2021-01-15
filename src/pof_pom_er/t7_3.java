package pof_pom_er;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class t7_3 {
	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest test;
	static ExtentTest test1;
	static ExtentTest test2;
	static ExtentTest test3;
	static ExtentTest test4;
	static ExtentTest test5;
	static ExtentTest test6;
	static ExtentTest test7;
	static ExtentTest test8;
	static Extent_reports exm = new Extent_reports(driver);
	static Actions actions;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		extent = Extent_reports.GetExtent();
		test = Extent_reports.createTest("name", "desc");
		test1 = Extent_reports.createTest1("name", "desc");
		test2 = Extent_reports.createTest2("name", "desc");
		test3 = Extent_reports.createTest3("name", "desc");
		test4 = Extent_reports.createTest4("name", "desc");
		test5 = Extent_reports.createTest5("name", "desc");
		test6 = Extent_reports.createTest6("name", "desc");
		test7 = Extent_reports.createTest7("name", "desc");
		test8 = Extent_reports.createTest8("name", "desc");
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://edu.gov.il/owlHeb/Pages/default.aspx");
		actions = new Actions(driver);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		extent.flush();
		driver.quit();
	}

	@Test
	public void test001() throws InterruptedException, IOException, AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[2]/a"));
		actions.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@id='navbar']/ul/li[2]/ul/li/div/ul/li/a"));
		actions.click(submenu.get(0)).perform();
		Thread.sleep(1000);
		if (driver.getTitle().equals("אוכלוסיות ייחודיות")) {
			test.pass("gurden - link 1");
		} else {
			test.fail("gurden - link 1",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		Thread.sleep(1000);
	}

	@Test
	public void test002() throws InterruptedException, IOException, AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[2]/a"));
		actions.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@id='navbar']/ul/li[2]/ul/li/div/ul/li/a"));
		actions.click(submenu.get(1)).perform();
		Thread.sleep(1000);
		if (driver.getTitle().equals("הורות - הורים וילדים")) {
			test1.pass("gurden - link 2");
		} else {
			test1.fail("gurden - link 2",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		Thread.sleep(1000);

	}

	@Test
	public void test003() throws InterruptedException, IOException, AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[2]/a"));
		actions.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@id='navbar']/ul/li[2]/ul/li/div/ul/li/a"));
		actions.click(submenu.get(2)).perform();
		Thread.sleep(1000);
		if (driver.getTitle().equals("יוזמות חינוכיות ורפורמות")) {
			test2.pass("gurden - link 3");
		} else {
			test2.fail("gurden - link 3",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		Thread.sleep(1000);
	}

	@Test
	public void test004() throws InterruptedException, IOException, AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[2]/a"));
		actions.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@id='navbar']/ul/li[2]/ul/li/div/ul/li/a"));
		actions.click(submenu.get(3)).perform();
		Thread.sleep(1000);
		if (driver.getTitle().equals("מחוץ לגן")) {
			test3.pass("gurden - link 4");
		} else {
			test3.fail("gurden - link 4",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		Thread.sleep(1000);
	}

	@Test
	public void test005() throws InterruptedException, IOException, AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[2]/a"));
		actions.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@id='navbar']/ul/li[2]/ul/li/div/ul/li/a"));
		actions.click(submenu.get(4)).perform();
		Thread.sleep(1000);
		if (driver.getTitle().equals("מקצועות ותחומי לימוד")) {
			test4.pass("gurden - link 5");
		} else {
			test4.fail("gurden - link 5",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		Thread.sleep(1000);
	}

	@Test
	public void test006() throws InterruptedException, IOException, AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[2]/a"));
		actions.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@id='navbar']/ul/li[2]/ul/li/div/ul/li/a"));
		actions.click(submenu.get(5)).perform();
		Thread.sleep(1000);
		if (driver.getTitle().equals("תקנות ומינהלות")) {
			test5.pass("gurden - link 6");
		} else {
			test5.fail("gurden - link 6",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		Thread.sleep(1000);
	}

	@Test
	public void test007() throws InterruptedException, IOException, AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[7]/a"));
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@id='navbar']/ul/li[7]/ul/li/a"));
		actions.moveToElement(menu).perform();
		Thread.sleep(1000);
		actions.moveToElement(submenu.get(0)).click().perform();
		if (driver.getTitle().equals("צפייה בציוני בחינות הבגרות")) {
			test6.pass("service - link 1");
		} else {
			test6.fail("service - link 1",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		Thread.sleep(1000);
	}

	@Test
	public void test008() throws InterruptedException, IOException, AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().back();
		WebElement menu = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[7]/a"));
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@id='navbar']/ul/li[7]/ul/li/a"));
		actions.moveToElement(menu).perform();
		Thread.sleep(1000);
		actions.moveToElement(submenu.get(1)).click().perform();
		Thread.sleep(1000);
		if (driver.getTitle().equals("תיק תוכניות לימודים לעובדי הוראה")) {
			test7.pass("service - link 2");
		} else {
			test7.fail("service - link 2",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		Thread.sleep(1000);
	}

	@Test
	public void test009() throws InterruptedException, IOException, AWTException {
		Thread.sleep(1000);
		driver.navigate().back();
		WebElement menu = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[7]/a"));
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@id='navbar']/ul/li[7]/ul/li/a"));
		actions.moveToElement(menu).perform();
		Thread.sleep(1000);
		actions.moveToElement(submenu.get(2)).click().perform();
		Thread.sleep(1000);
		if (driver.getTitle().equals("פניות ותלונות הציבור")) {
			test8.pass("service - link 3");
		} else {
			test8.fail("service - link 3",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		Thread.sleep(1000);
	}
}
