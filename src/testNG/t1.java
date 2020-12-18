package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class t1 {
  static WebDriver driver;

  @Test
  public void f() {
  }
  @Parameters({ "browser" })
  @BeforeTest
  public void openBrowser(String browser) {
	  try {
		  if ( browser.equalsIgnoreCase ("chrome")) {
			  System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
				System.setProperty("webdriver.chrome.silentOutput", "true");
			    driver=new ChromeDriver();
			    driver.get("https://www.nisha.co.il/%D7%98%D7%91%D7%9C%D7%90%D7%95%D7%AA-%D7%A9%D7%9B%D7%A8");
			    }
		  else if ( browser.equalsIgnoreCase ("FF")) {
			  System.setProperty("webdriver.gecko.driver", "C:\\temp\\geckodriver.exe");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
				driver = new FirefoxDriver();
			    driver.get("https://www.nisha.co.il/%D7%98%D7%91%D7%9C%D7%90%D7%95%D7%AA-%D7%A9%D7%9B%D7%A8");
				}
		  }catch (Exception e) {
		  }
  }
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
