package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class t7_1 {
	
	 static WebDriver driver;
	 static pofModle pof;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("http://www.netogreen.co.il/Calculators/Nutrition-Calories.aspx");
	    
	}
	@Before
	public  void befor() throws Exception {
		pof = new pofModle();
		driver.navigate().refresh();
		Thread.sleep(2000);
		pof = PageFactory.initElements (driver, pofModle.class);
		

	}	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	
	}
	@Test
	public void test001() {
		try {

			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(2000);
			String resultString= pof.result.get(0).getText();
			if (resultString.contains("לחם")) {
				System.out.println("test1 pass");
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}	
	}	

	@Test
	public void test002() throws InterruptedException {
		try {
			pof.searchTxt.sendKeys("123");
			pof.Button1.click();
			Thread.sleep(2000);
			String resultString= pof.result.get(0).getText();
			if (resultString.contains("לא נמצאו מזונות, נסה שנית.")) {
				System.out.println("test2 pass");
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	

	@Test
	public void test003() {
		try {
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(2000);
		    pof.result.get(3).click();
		    pof.add.click();
		    Alert alert = driver.switchTo().alert();
		   String alartString= alert.getText();	
			Thread.sleep(2000);
			if (alartString.contains("יש לבחור  יחידת מידה וכמות")) {
				System.out.println(alartString);
				System.out.println("test3 pass");

			}
			driver.switchTo().defaultContent();
		} catch (Exception e) {
		}
		
	}

	@Test
	public void test004() {
		try {
			pof.quantity.sendKeys("wewdsfasq");
			Thread.sleep(5000);
			String quantityString=pof.quantity.getText();
			
			if(quantityString.isEmpty()){
				   System.out.println("test4 pass"); 
			}			
		} catch (Exception e) {
		}
		
	}

	@Test
	public void test005() {
		try {
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(2000);
			pof.result.get(3).click();
			Thread.sleep(2000);
			pof.quantity.sendKeys("900000000");
			Thread.sleep(2000);
			pof.add.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String alartString= alert.getText();
			if (alartString.contains("קוד: 3001")) {
				System.out.println(alartString);
				System.out.println("test5 pass");
			}
			
			driver.switchTo().defaultContent();

		} catch (Exception e) {
		}
		
	}

	@Test
	public void test006() {
		try {
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(2000);
			pof.result.get(3).click();
			Thread.sleep(2000);
			pof.quantity.sendKeys("5");
			Thread.sleep(2000);
			pof.add.click();
			Thread.sleep(2000);
			if (pof.first.isDisplayed()) {
				System.out.println("test6 pass");
			}

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Test
	public void test007() {
		try {
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(2000);
			pof.result.get(0).click();
			Thread.sleep(2000);
			pof.quantity.sendKeys("2");
			Thread.sleep(2000);
			pof.add.click();
			Thread.sleep(5000);
			if (pof.first.isDisplayed()) {
				System.out.println("test7 pass");
			}	

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}


	@Test
	public void test008() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(2000);
			pof.result.get(3).click();
			Thread.sleep(2000);
			pof.quantity.sendKeys("2");
			Thread.sleep(2000);
			pof.add.click();
			Thread.sleep(2000);
			pof.result.get(4).click();
			pof.add.click();
			Thread.sleep(2000);
			pof.remove.click();
			Thread.sleep(2000);
			if (pof.resultes.size()<3) {
				System.out.println("test8 pass");
			}

		} catch (Exception e) {
		}
	}

	@Test
	public void test009() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(2000);
			pof.result.get(5).click();
			Thread.sleep(2000);
			pof.quantity.sendKeys("2");
			Thread.sleep(2000);
			pof.add.click();
			if (pof.first.isDisplayed()) {
				System.out.println("test9 pass");

			}

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Test
	public void test010() {
		try {
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(2000);
			pof.result.get(3).click();
			Thread.sleep(2000);
			pof.quantity.sendKeys("2");
			Thread.sleep(2000);
			pof.add.click();
			Thread.sleep(2000);
			pof.result.get(3).click();
			pof.result.get(4).click();
			Thread.sleep(2000);
			pof.add.click();
			Thread.sleep(2000);
			String first=pof.caloris.get(0).getText();
			int first1=Integer.parseInt(first);
			String secand=pof.caloris.get(1).getText();
			int secand1=Integer.parseInt(secand);
			int sum=first1+secand1;
			String sumCaloris=pof.sumCaloris.getText().replace(" קלוריות", "");
			int sumCaloris1=Integer.parseInt(sumCaloris);
			if (sumCaloris1==sum) {
				System.out.println("הקלריות שוות");
				System.out.println("test10 pass");
			}	

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Test
	public void test011() {
		try {
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(2000);
			pof.result.get(3).click();
			Thread.sleep(2000);
			pof.quantity.sendKeys("2");
			Thread.sleep(2000);
			pof.add.click();
			Thread.sleep(2000);
			pof.result.get(3).click();
			pof.result.get(4).click();
			Thread.sleep(2000);
			pof.add.click();
			Thread.sleep(2000);
			String first=pof.Carbo1.getText();
			int first1=Integer.parseInt(first);
			String secand=pof.Carbo2.getText();
			int secand1=Integer.parseInt(secand);
			int sum=first1+secand1;
			String sumCarbo=pof.sumCarbo.getText().replace(" גרם", "");
			int sumCarbo1=Integer.parseInt(sumCarbo);
			if (sumCarbo1==sum) {
				System.out.println("הפחמימות שוות");
				System.out.println("test11 pass");
			}	

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}


	@Test
	public void test012() {
		try {
			driver.get("https://www.nestle.com/jobs/search-jobs?keyword=&country=IL&location=&career_area=All&company=All#");
			Thread.sleep(1500);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
		//	js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(3000);
			int count =0;
		for (int i = 0; i < pof.pages.size(); i++) {
			for (int j = 1; j < pof.jobs.size(); j++) {
				count++;
			}
			pof.pages.get(i).click();
		}
			System.out.println(count);
			System.out.println("test12 pass");
		} catch (Exception e) {
		}
	}
	

}
