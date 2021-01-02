package steimatzky;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class navi {
	public static void close(WebDriver driver) {
		@SuppressWarnings("resource")
		Scanner cons = new Scanner(System.in);
		System.out.println("press enter to close");
		cons.nextLine();
		driver.quit();
	}

	static WebDriver driver;
	static Actions actions;
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
	static pofModle pof;

	static Extent_reports exm = new Extent_reports(driver);

	@BeforeClass
	public void beforeClass() {
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

		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		actions = new Actions(driver);
	}

	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		pof = new pofModle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pof = PageFactory.initElements(driver, pofModle.class);
	}

	@AfterClass
	public void afterClass() {
		// close(driver);
		extent.flush();
		driver.close();
	}

	@Test(groups = "mCategory", priority = 1, enabled = true)
	public void sales() throws IOException, AWTException {
		test.info("--------sales link test --------");
		// Get link text and click on the link
		String saleString = pof.sales.getText();
		pof.sales.click();
		// Check if page title is equal to link text
		if (saleString.equals(driver.findElement(By.className("pageTitle")).getText())
				&& driver.getTitle().contains(saleString)) {
			test.pass("you in " + saleString + " page");
		} else {
			test.fail("you not in " + saleString + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
	}

	@Test(groups = "mCategorys", priority = 2, enabled = true)
	public void mCategorys() throws IOException, AWTException {
		test.info("--------mCategorys links test --------");
		int mCategoryNum = 1;
		while (mCategoryNum < 13) {
			WebElement topItem = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[" + mCategoryNum + "]/a"));
			// Get link text and click on the link
			String topItemString = topItem.getText();
			topItem.click();
			// Check if page title is equal to link text
			if (topItemString.contains(driver.findElement(By.className("pageTitle")).getText())
					&& driver.getTitle().contains(topItemString)) {
				test.pass("you in " + topItemString + " page");
			} else if (driver.findElement(By.className("pageTitle")).getText().contains(topItemString)
					&& driver.getTitle().contains("בית")) {
				test.pass("you in home page");
			} else {
				test.fail("you not in " + topItemString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			mCategoryNum++;
		}
	}

	@Test(groups = "mCategory", priority = 3, enabled = true)
	public void club() throws IOException, AWTException {
		test.info("--------club link test --------");
		// Get link text and click on the link
		String clubString = "חברות במועדון הקוראים של סטימצקי - הסיפור שלי";
		pof.club.click();
		// Check if page title is equal to link text
		if (clubString.contains(driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText())
				&& driver.getTitle().contains(clubString)) {
			test.pass("you in " + clubString + " page");
		} else {
			test.fail("you not in " + clubString + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
	}

	@Test(groups = "subCategory", priority = 4, enabled = true)
	public void books_subCategory() throws IOException, AWTException, InterruptedException {
		test1.info("--------books_subCategory links test --------");
		int clumNum = 1;
		while (clumNum <= 5) {
			int subcatagoryNum = 1;
			while (subcatagoryNum < 15) {
				// move to books category
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				actions.moveToElement(pof.books).perform();
				// click on sub-category
				WebElement subcatagory = driver.findElement(By.xpath("//div[@id='acc_categories_menu']/ul[@id='catMenu']/li[@id='menuCat-398']/div/ul/li[" + clumNum + "]/ul/li[" + subcatagoryNum + "]/a"));
				// Get link text and click on the link
				String subcatagoryString = subcatagory.getText();
				subcatagory.click();
				Thread.sleep(3000);
				// if open new tab
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// Check if the browser in right page
					if (driver.getTitle().contains("ספרים דיגיטליים בעברית להורדה")) {
						test1.pass("you in " + subcatagoryString + " page");
						driver.close();
						driver.switchTo().window(tabs2.get(0));
					} else {
						test1.fail("you not in " + subcatagoryString + " page",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
						driver.close();
						driver.switchTo().window(tabs2.get(0));
					}
				} else {
					// Check if the browser in right page
					if (subcatagoryString.contains(driver.findElement(By.xpath("//div[@id='content']/h1")).getText())) {
						test1.pass("you in " + subcatagoryString + " page");
					} else {
						test1.fail("you not in " + subcatagoryString + " page",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
					}
					// stop the loop in last sub-category
					if (subcatagoryString.equals("משרדאות והנהלת חשבונות")) {
						if (subcatagoryString.contains(driver.findElement(By.xpath("//div[@id='content']/h1")).getText())
								&& driver.getTitle().contains(subcatagoryString)) {
							test1.pass("you in " + subcatagoryString + " page");
							break;
						} else {
							test1.fail("you not in " + subcatagoryString + " page",
									MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
							break;
						}
					}
				}
				subcatagoryNum++;
			}
			clumNum++;
		}
	}

	@Test(groups = "subCategory", priority = 5, enabled = true)
	public void English_Books_subCategory() throws IOException, AWTException {
		test1.info("--------English_Books_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 7) {
			actions.moveToElement(pof.Ebooks).perform();
			WebElement subCatergory = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[2]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			String subCatergorysString = subCatergory.getText();
			subCatergory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subCatergorysString.contains(driver.findElement(By.xpath("//h1")).getText())) {
				test1.pass("you in " + subCatergorysString + " page");
			} else {
				test1.fail("you not in " + subCatergorysString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 6, enabled = true)
	public void games_subCategory() throws IOException, AWTException {
		test2.info("--------games_subCategory links test --------");
		actions.moveToElement(pof.games).perform();
		// Get link text and click on the link
		String subCatergorysString = pof.Subgames.getText();
		pof.Subgames.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Check if page title is equal to link text
		if (subCatergorysString.contains(driver.findElement(By.xpath("//h1")).getText())) {
			test2.pass("you in " + subCatergorysString + " page");
		} else {
			test2.fail("you not in " + subCatergorysString + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
	}

	@Test(groups = "subCategory", priority = 7, enabled = true)
	public void Gifts_and_leisure_subCategory() throws IOException, AWTException {
		test2.info("--------Gifts_and_leisure_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 8) {
			actions.moveToElement(pof.Gifts_and_leisure).perform();
			WebElement subCatergory = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[6]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			String subCatergorysString = subCatergory.getText();
			subCatergory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subCatergorysString.contains(driver.findElement(By.xpath("//h1")).getText())) {
				test2.pass("you in " + subCatergorysString + " page");
			} else {
				test2.fail("you not in " + subCatergorysString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 8, enabled = true)
	public void music_subCategory() throws InterruptedException, IOException, AWTException {
		test3.info("--------music_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 8) {
			actions.moveToElement(pof.music).perform();
			WebElement subCatergory = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[7]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			String subCatergorysString = subCatergory.getText().trim();
			subCatergory.click();
			// Check if page title is equal to link text
			if (subCatergorysString.contains(driver.findElement(By.xpath("//h1[@class='pageTitle']")).getText())) {
				test3.pass("you in " + subCatergorysString + " page");
			} else {
				test3.fail("you not in " + subCatergorysString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 9, enabled = true)
	public void Appliances_subCategory() throws IOException, AWTException {
		test4.info("--------Appliances_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 4) {
			actions.moveToElement(pof.Appliances).perform();
			WebElement subCatergory = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[8]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			String subCatergorysString = subCatergory.getText();
			subCatergory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subCatergorysString.contains(driver.findElement(By.xpath("//h1")).getText())) {
				test4.pass("you in " + subCatergorysString + " page");
			} else {
				test4.fail("you not in " + subCatergorysString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 10, enabled = true)
	public void Smartphones_subCategory() throws IOException, AWTException {
		test4.info("--------Smartphones_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 2) {
			actions.moveToElement(pof.Smartphones).perform();
			WebElement subCatergory = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[9]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			String subCatergorysString = subCatergory.getText();
			subCatergory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subCatergorysString.contains(driver.findElement(By.xpath("//h1")).getText())) {
				test4.pass("you in " + subCatergorysString + " page");
			} else {
				test4.fail("you not in " + subCatergorysString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 11, enabled = true)
	public void Cosmetics_and_perfumes_subCategory() throws IOException, AWTException {
		test5.info("--------Cosmetics_and_perfumes_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 3) {
			actions.moveToElement(pof.Cosmetics_and_perfumes).perform();
			WebElement subCatergory = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[10]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			String subCatergorysString = subCatergory.getText();
			subCatergory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subCatergorysString.contains(driver.findElement(By.xpath("//h1")).getText())) {
				test5.pass("you in " + subCatergorysString + " page");
			} else {
				test5.fail("you not in " + subCatergorysString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 12, enabled = true)
	public void HOME_subCategory() throws IOException, AWTException {
		test6.info("--------HOME_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 5) {
			actions.moveToElement(pof.HOME).perform();
			WebElement subCatergory = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[11]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			String subCatergorysString = subCatergory.getText();
			subCatergory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subCatergorysString.contains(driver.findElement(By.xpath("//h1")).getText())) {
				test6.pass("you in " + subCatergorysString + " page");
			} else {
				test6.fail("you not in " + subCatergorysString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 13, enabled = true)
	public void camping_subCategory() throws IOException, AWTException {
		test7.info("--------camping_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 2) {
			actions.moveToElement(pof.camping).perform();
			WebElement subCatergory = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[12]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			String subCatergorysString = subCatergory.getText();
			subCatergory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subCatergorysString.contains(driver.findElement(By.xpath("//h1")).getText())) {
				test7.pass("you in " + subCatergorysString + " page");
			} else {
				test7.fail("you not in " + subCatergorysString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 14, enabled = true)
	public void Costumers_club_subCategory() throws IOException, AWTException {
		test8.info("--------Costumers_club_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 4) {
			actions.moveToElement(pof.club).perform();
			WebElement subCatergory = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[13]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			String subCatergorysString = subCatergory.getText();
			subCatergory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subCatergorysString.equals("חברות במועדון")) {
				if (driver.findElement(By.xpath("//div/h1")).getText()
						.contains("חברות במועדון הקוראים של סטימצקי - הסיפור שלי")) {
					test8.pass("you in " + subCatergorysString + " page");
				} else {
					test8.fail("you not in " + subCatergorysString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
				}
			} else if (subCatergorysString.equals("תקנון המועדון")) {
				if (driver.findElement(By.xpath("//div/h1")).getText().contains("תקנון מועדון הקוראים של סטימצקי")) {
					test8.pass("you in " + subCatergorysString + " page");
				} else {
					test8.fail("you not in " + subCatergorysString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
				}
			}

			if (subCatergorysString.contains(driver.findElement(By.xpath("//div/h1")).getText())) {
				test8.pass("you in " + subCatergorysString + " page");
			} else {
				test8.fail("you not in " + subCatergorysString + " page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
			}
			subCategorynum++;
		}
	}
}