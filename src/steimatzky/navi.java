package steimatzky;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

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

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		actions = new Actions(driver);
	}

	@AfterClass
	public void afterClass() {
		close(driver);
	}

	@Test(groups = "mCategory", enabled = false)
	public void test1() {
		WebElement sales = driver.findElement(By.xpath("//a[@class='sales']"));
		String saleString = sales.getText();
		sales.click();
		if (saleString.equals(driver.findElement(By.className("pageTitle")).getText())
				&& driver.getTitle().contains(saleString)) {
			System.out.println("you in " + saleString + " page");
		} else {
			System.err.println("you not in " + saleString + " page");
		}
	}

	@Test(groups = "mCategory", enabled = false)
	public void test2() {
		int mCategoryNum = 1;
		while (mCategoryNum < 13) {
			WebElement topItem = driver
					.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[" + mCategoryNum + "]/a"));
			String topItemString = topItem.getText();
			topItem.click();
			if (topItemString.contains(driver.findElement(By.className("pageTitle")).getText())
					&& driver.getTitle().contains(topItemString)) {
				System.out.println("you in " + topItemString + " page");
			} else if (driver.findElement(By.className("pageTitle")).getText().contains(topItemString)
					&& driver.getTitle().contains("בית")) {
				System.out.println("you in home page");
			} else {
				System.err.println("you not in " + topItemString + " page");
			}
			mCategoryNum++;
		}
	}

	@Test(groups = "mCategory", enabled = false)
	public void test3() {
		WebElement club = driver.findElement(By.xpath("//a[@class='club']"));
		String clubString = "חברות במועדון הקוראים של סטימצקי - הסיפור שלי";
		club.click();
		if (clubString.contains(driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText())
				&& driver.getTitle().contains(clubString)) {
			System.out.println("you in " + clubString + " page");
		} else {
			System.err.println("you not in " + clubString + " page");
		}

	}

	@Test(groups = "subCategory")
	public void test4() throws InterruptedException {
		int clumNum = 1;
		while (clumNum <= 5) {
			int subcatagoryNum = 1;
			while (subcatagoryNum < 15) {
				// move to books category
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				WebElement books = driver.findElement(By.xpath("//div[@id='site']//ul[@id='catMenu']/li[1]/a"));
				actions.moveToElement(books).perform();
				//click on subcatagory
				WebElement subcatagory = driver.findElement(By.xpath("//div[@id='acc_categories_menu']/ul[@id='catMenu']/li[@id='menuCat-398']/div/ul/li["+ clumNum + "]/ul/li[" + subcatagoryNum + "]/a"));
				String subcatagoryString = subcatagory.getText();
				subcatagory.click();
				Thread.sleep(3000);
				// if open new tab
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// Check if the browser in right page
					if (driver.getTitle().equals("ספרים דיגיטליים בעברית להורדה")) {
						System.out.println("you in " + subcatagoryString + " page");
						driver.close();
						driver.switchTo().window(tabs2.get(0));
					} else {
						System.err.println("you not in " + subcatagoryString + " page");
						driver.close();
						driver.switchTo().window(tabs2.get(0));
					}					

				} else {
					// Check if the browser in right page
					if (subcatagoryString.contains(driver.findElement(By.xpath("//div[@id='content']/h1")).getText())
							&& driver.getTitle().contains(subcatagoryString)) {
						System.out.println("you in " + subcatagoryString + " page");
					} else {
						System.err.println("you not in " + subcatagoryString + " page");
					}
					//stop the loop in last subcatagory
					if (subcatagoryString.equals("משרדאות והנהלת חשבונות")) {
						if (subcatagoryString.contains(driver.findElement(By.xpath("//div[@id='content']/h1")).getText())
								&& driver.getTitle().contains(subcatagoryString)) {
							System.out.println("you in " + subcatagoryString + " page");
							break;
						} else {
							System.err.println("you not in " + subcatagoryString + " page");
							break;
						}
						
					}

				}

				subcatagoryNum++;
			}
			clumNum++;
		}

	}

}
