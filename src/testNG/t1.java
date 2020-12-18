package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
		 try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("testNG.txt", true)))) {
			    out.println(text);
		 }catch (Exception e) {
		 }
	}
  static WebDriver driver;
  static String browserName;


  @Parameters({"browser"})
  @BeforeTest
  public void openBrowser(String browser) {
		  try {
			if ( browser.equalsIgnoreCase ("chrome")) {
				  System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
				  System.setProperty("webdriver.chrome.silentOutput", "true");
				  driver=new ChromeDriver();
				  driver.get("https://www.nisha.co.il/%D7%98%D7%91%D7%9C%D7%90%D7%95%D7%AA-%D7%A9%D7%9B%D7%A8");
				  Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
					browserName = cap.getBrowserName().toLowerCase();
				    }
			  else if ( browser.equalsIgnoreCase ("FF")) {
				  System.setProperty("webdriver.gecko.driver", "C:\\temp\\geckodriver.exe");
				  System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
				  driver = new FirefoxDriver();
				  driver.get("https://www.nisha.co.il/%D7%98%D7%91%D7%9C%D7%90%D7%95%D7%AA-%D7%A9%D7%9B%D7%A8");
				  Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
				  browserName = cap.getBrowserName().toLowerCase();
					}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		    e.printStackTrace();
		}
		 
  }
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void AfterClass() {
	  driver.quit();
  }
  @Test(groups = "list")
  public void test1() {
	  if (browserName.equals("chrome")) {
		  List<WebElement> jobsElements=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/div/div[7]/div/h3"));
		  for (WebElement webElement : jobsElements) {
		  System.out.println(browserName +":"+ webElement.getText());	
	}
		  }else if (browserName.equals("FF")) {
		 List<WebElement> jobsElements=driver.findElements(By.xpath("//div[3]/section[1]/section/section[2]/div/div/div[7]/div/h3"));
		  for (WebElement webElement : jobsElements) {
			  String job=browserName+":"+webElement.getAttribute("value");
		  fileWrite(job);
		  }
		  }
	  }
  @Test(groups = "list")
  public void test2() {
  }
 
  @Test(groups = "average")
  public void test3() {
  }
  @Test(groups = "average")
  public void test4() {
  }

}
