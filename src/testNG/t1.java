package testNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class t1 {
    static void fileWrite(String text) {
		 try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("firefox.txt", true)))) {
			    out.println(text);
		 }catch (Exception e) {
		 }
	}
   
  static WebDriver driver;
  static String browserName;
  
  

  @Parameters({"browser"})
  @BeforeTest 
  public void BeforeTest(String browser) throws InterruptedException {
	  if (browser.equalsIgnoreCase ("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
		  driver.get("https://www.nisha.co.il/%D7%98%D7%91%D7%9C%D7%90%D7%95%D7%AA-%D7%A9%D7%9B%D7%A8");
		  Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		  browserName = cap.getBrowserName().toLowerCase();
		  }
	  else if ( browser.equalsIgnoreCase ("FF")) {
		  WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
			driver = new FirefoxDriver();
		  driver.get("https://www.nisha.co.il/%D7%98%D7%91%D7%9C%D7%90%D7%95%D7%AA-%D7%A9%D7%9B%D7%A8");
		  Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		  browserName = cap.getBrowserName().toLowerCase();
		  }  
  }

  @AfterClass
  public void AfterClass() {
	  driver.quit();
}
  @Test(groups = "list")
  public void test1() throws InterruptedException {
	  if (browserName.equals("chrome")) {
		  List<WebElement> jobsElements=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/div/div[7]/div/h3"));
		  for (WebElement webElement : jobsElements) {
		  System.out.println(browserName +":"+ webElement.getText());
	}
		  }if (browserName.equals("firefox")) {
			  List<WebElement> jobsElements=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/div/div[7]/div/h3"));
			  for (WebElement webElement : jobsElements) {
				  fileWrite(browserName +":"+ webElement.getText());
		}
			  }
		  }
  
  @Test(groups = "list",enabled = false)
  public void test2() throws InterruptedException {
	  if (browserName.equals("chrome")) {
		  List<WebElement> jobsElements=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/table/tbody/tr/td/span/a/span"));
	  for (WebElement webElement : jobsElements) {
	  System.out.println(browserName +":"+ webElement.getText());	
	  }
	  } if (browserName.equals("firefox")) {
		  List<WebElement> jobsElements=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/table/tbody/tr/td/span/a/span"));
	  for (WebElement webElement : jobsElements) {
		  fileWrite(browserName +":"+ webElement.getText());
		  }
	  }
	  }
 
  @Test(groups = "average",enabled = false)
  public void test3() {
	  int avgSalaery=0;
	  if (browserName.equals("chrome")) {
	  System.out.println(browserName +"----salary of Software and Hardware----");
	  int numTables=2;
	  while (numTables<=5) {
		int saleyNum=0;
		List<WebElement> salaryList=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/div/div[7]/div["+numTables+"]/table/tbody/tr/td[2]"));
		for (int i = 1; i < salaryList.size(); i++) {
				System.out.println(browserName +Integer.parseInt(salaryList.get(i).getText().substring(0, 2)));
				saleyNum +=Integer.parseInt(salaryList.get(i).getText().substring(0, 2));
			}
			  numTables=numTables+3;
			  avgSalaery=saleyNum/salaryList.size(); 
		}
	  System.out.println(browserName +"The avg of salarey: "+avgSalaery);
	  } if (browserName.equals("firefox")) {
		  fileWrite(browserName +"----salary of Software and Hardware----");
		  int numTables=2;
		  while (numTables<=5) {
			int saleyNum=0;
			List<WebElement> salaryList=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/div/div[7]/div["+numTables+"]/table/tbody/tr/td[2]"));
			for (int i = 1; i < salaryList.size(); i++) {
				fileWrite(browserName +Integer.parseInt(salaryList.get(i).getText().substring(0, 2)));
					saleyNum +=Integer.parseInt(salaryList.get(i).getText().substring(0, 2));
				}
				  numTables=numTables+3;
				  avgSalaery=saleyNum/salaryList.size(); 
			}
		  fileWrite(browserName +"The avg of salarey: "+avgSalaery);
		  }
	  }
	  
  
  @Test(groups = "average",enabled = false)
  public void test4() {
	  int avgSalaery=0;
	  if (browserName.equals("chrome")) {
	  System.out.println(browserName +"----salary of QA and Support, System and IT----");
	  int numTables=7;
	  while (numTables<=9) {
		int saleyNum=0;
		List<WebElement> salaryList=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/div/div[7]/div["+numTables+"]/table/tbody/tr/td[2]"));
		for (int i = 1; i < salaryList.size(); i++) {
				System.out.println(browserName +Integer.parseInt(salaryList.get(i).getText().substring(0, 2)));
				saleyNum +=Integer.parseInt(salaryList.get(i).getText().substring(0, 2));
			}
			  numTables=numTables+2;
			  avgSalaery=saleyNum/salaryList.size(); 
		}
	  System.out.println(browserName +"The avg of salarey: "+avgSalaery);
  }	   if (browserName.equals("firefox")) {
	  fileWrite(browserName +"----salary of QA and Support, System and IT----");
	  int numTables=7;
	  while (numTables<=9) {
		int saleyNum=0;
		List<WebElement> salaryList=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/div/div[7]/div["+numTables+"]/table/tbody/tr/td[2]"));
		for (int i = 1; i < salaryList.size(); i++) {
			fileWrite(browserName +Integer.parseInt(salaryList.get(i).getText().substring(0, 2)));
				saleyNum +=Integer.parseInt(salaryList.get(i).getText().substring(0, 2));
			}
			  numTables=numTables+2;
			  avgSalaery=saleyNum/salaryList.size(); 
		}
	  fileWrite(browserName +"The avg of salarey: "+avgSalaery);
	  }
  }
  }
