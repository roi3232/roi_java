package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class t1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
  try {
	  driver.get("https://www.yellowpages.com/");
	  driver.getTitle();
	  driver.findElement(By.id("query")).sendKeys("pizza");
	  driver.findElement(By.id("location")).clear();
	  driver.findElement(By.id("location")).sendKeys("london");
	  driver.findElement(By.xpath("//*[@id=\"search-form\"]/button")).click();
	  driver.navigate().back();
	  System.out.println(driver.getCurrentUrl());
	  System.out.println(driver.findElement(By.id("tagline")).getText());
	  driver.close();
	  } catch (Exception e) {
		  e.printStackTrace();
		  }
        
      //  
	}
//
}
