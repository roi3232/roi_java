package selenium;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	 static WebDriver driver;
	 static double shufersal=0;
	 static double rami_levy=0;
	 static double Quik =0;
	 static Robot robot;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
	 driver=new ChromeDriver();
	 robot = new Robot();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.shufersal.co.il/online/he/");
		driver.manage().window().maximize();
		driver.findElement(By.id("js-site-search-input")).sendKeys("שניצל תירס טבעול");
		driver.findElement(By.cssSelector("button[class='btnSubmit js_search_button']")).click();
		WebElement price=driver.findElement(By.xpath("//main//div//ul//section//li[1]//div/div//div[@class='line']/span[1]/span[@class='number']"));
		Thread.sleep(2000);
		
		String price1=price.getText();
		price1=price1.replace("₪", "");
		price1=price1.trim();
		shufersal=Double.parseDouble(price1);
		System.out.println("המחיר של שופרסל:"+price1);
		Thread.sleep(2000);
		
	}
	@Test
	public void test2() throws InterruptedException {
		driver.get("https://www.rami-levy.co.il/he/shop");
		driver.manage().window().maximize();
		driver.findElement(By.id("destination")).sendKeys("שניצל תירס טבעול");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div/div[1]/div[3]/button[2]")).click();
		Thread.sleep(2000);
		List<WebElement> price=driver.findElements(By.xpath("//div[1]//div/div[1]/div[2]/div[2]//div/div[3]/div//div/div/div/button/div/div[2]/div[2]/div[2]/div/div/span"));
		String price1=price.get(0).getText();
		price1=price1.replace("₪", "");
		price1=price1.trim();
		rami_levy=Double.parseDouble(price1);
		System.out.println("המחיר של רמי לוי:"+price1);
		Thread.sleep(2000);
		
	}
	
	@Test
	public void test3 () throws InterruptedException {
		driver.get("https://quik.co.il/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.className("searchInput_2RR")).sendKeys("שניצל תירס טבעול");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		List<WebElement> strong=driver.findElements(By.xpath("/html/body/div[3]/main/div[1]/div[3]/div/div[2]/div/div[1]/div[5]/div/strong"));
		List<WebElement> small=driver.findElements(By.xpath("/html/body/div[3]/main/div[1]/div[3]/div/div[2]/div/div[1]/div[5]/div/small[2]"));	
		String price1=strong.get(0).getText();
		String price2=small.get(0).getText();
		String price=price1+"."+price2;
		Quik=Double.parseDouble(price);
		System.out.println("המחיר של קוויק:"+price);
		Thread.sleep(2000);
		

	}
	@Test
	public void test4 () {
		if (shufersal<rami_levy && shufersal<Quik) {
			System.out.println("שופרסל הכי זול");
		}else if (rami_levy<shufersal && rami_levy<Quik) {
			System.out.println("רמי לוי הכי זול");
		}else if (Quik<rami_levy && Quik<shufersal) {
			System.out.println("קוויק הכי זולה");
		}
	}

}
