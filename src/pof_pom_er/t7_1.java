package pof_pom_er;

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pof = PageFactory.initElements (driver, pofModle.class);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test001() throws InterruptedException {
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(1000);
			String resultString= pof.result.get(0).getText();
			if (resultString.contains("לחם")) {
				System.out.println("test1 pass");
			}else {
				throw new RuntimeException();
			}	
	}	
	
	@Test
	public void test002() throws InterruptedException {
			pof.searchTxt.clear();
			pof.searchTxt.sendKeys("123");
			pof.Button1.click();
			Thread.sleep(2000);
			String resultString= pof.result.get(0).getText();
			if (resultString.contains("לא נמצאו מזונות, נסה שנית.")) {
				System.out.println("test2 pass");
			}else {
				throw new RuntimeException();
			}
	}
	
	@Test
	public void test003() throws InterruptedException {
			pof.searchTxt.clear();
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(1000);
		    pof.result.get(3).click();
		    pof.add.click();
		    Alert alert = driver.switchTo().alert();
		    String alartString= alert.getText();	
			Thread.sleep(1000);
			if (alartString.contains("יש לבחור  יחידת מידה וכמות")) {
				System.out.println(alartString);
				System.out.println("test3 pass");
			}else {
				throw new RuntimeException();
			}
			driver.switchTo().alert().accept();
	}

	@Test
	public void test004() throws InterruptedException {
			pof.quantity.sendKeys("wewdsfasq");
			Thread.sleep(1000);
			String quantityString=pof.quantity.getText();
			if(quantityString.isEmpty()){
				   System.out.println("test4 pass"); 
			}	else {
				throw new RuntimeException();
			}		
		
		
	}
	
	@Test
	public void test005() throws InterruptedException {
		
			pof.quantity.sendKeys("900000000");
			Thread.sleep(1000);
			pof.add.click();
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alartString= alert.getText();
			if (alartString.contains("קוד: 3001")) {
				System.out.println(alartString);
				System.out.println("test5 pass");
			}else {
				throw new RuntimeException();
			}
			driver.switchTo().alert().accept();
	}
	
	@Test
	public void test006() throws InterruptedException {
		
			pof.quantity.clear();
			Thread.sleep(1000);
			pof.quantity.sendKeys("5");
			Thread.sleep(1000);
			pof.add.click();
			Thread.sleep(1000);
			if (pof.resultes.size()==2) {
				System.out.println("test6 pass");
			}else {
				throw new RuntimeException();
			}
	}

	@Test
	public void test007() throws InterruptedException {
		
			pof.searchTxt.clear();
			pof.quantity.clear();
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(1000);
			pof.result.get(0).click();
			Thread.sleep(1000);
			pof.quantity.sendKeys("2");
			Thread.sleep(1000);
			pof.add.click();
			Thread.sleep(1000);
			if (pof.resultes.size()==3) {
				System.out.println("test7 pass");
			}else {
				throw new RuntimeException();
			}	
	}

	@Test
	public void test008() throws InterruptedException {
		
			pof.remove.click();
			Thread.sleep(1000);
			if (pof.resultes.size()<3) {
				System.out.println("test8 pass");
			}else {
				throw new RuntimeException();
			}

	}
	@Test
	public void test009() throws InterruptedException {
		
			pof.searchTxt.clear();
			pof.quantity.clear();
			pof.searchTxt.sendKeys("לחם");
			pof.Button1.click();
			Thread.sleep(1000);
			pof.result.get(5).click();
			Thread.sleep(1000);
			pof.quantity.sendKeys("2");
			Thread.sleep(1000);
			pof.add.click();
			Thread.sleep(1000);
			if (pof.resultes.size()==3) {
				System.out.println("test9 pass");
			}else {
				throw new RuntimeException();
			}
	}

	@Test
	public void test010() {
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
			}else {
				throw new RuntimeException();
			}
	}

	@Test
	public void test011() {
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
			}	else {
				throw new RuntimeException();
			}
	}

	@Test
	public void test012() throws InterruptedException {
		
			driver.get("https://www.nestle.com/jobs/search-jobs?keyword=&country=IL&location=&career_area=All&company=All#");
			Thread.sleep(2000);	 
			int count =0;
		for (int i = 0; i < pof.pages.size(); i++) {
		//	JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,250)", "");
			for (int j = 1; j < pof.jobs.size(); j++) {
				count++;
			}
			pof.pages.get(i).click();
		}
			System.out.println(count);
			System.out.println("test12 pass");
		
	}
	

}
