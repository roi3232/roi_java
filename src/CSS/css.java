package CSS;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class css {
	  static WebDriver driver;

  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  System.setProperty("webdriver.chrome.silentOutput", "true");
	  driver=new ChromeDriver();
	  driver.get("https://www.ynet.co.il/home/0,7340,L-8,00.html");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  @Test(groups = "headline")
  public void test1() {
	  List<WebElement> headline=driver.findElements(By.xpath("//div[8]/div//div[1]/div[6]/div[2]/span//div/div[2]/div[2]/div//div//div[1]/a/span"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  for (int i = 0; i < headline.size(); i++) {
		if (headline.get(i).getCssValue("font-size").equals("14px")) {
			System.out.println("----------- news link: "+i+" -----------");
			System.out.println("size is :"+headline.get(i).getCssValue("font-size"));
		}else {
			System.out.println("----------- news link: "+i+" -----------");
			System.err.println("size is not equals to 14px"+headline.get(i).getCssValue("font-size"));
		}
	}
	  
  }
  @Test (groups = "headline")
  public void test2() {
	  List<WebElement> headline=driver.findElements(By.xpath("//div[8]/div//div[1]/div[6]/div[2]/span//div/div[2]/div[2]/div//div//div[1]/a/span"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  for (int i = 0; i < headline.size(); i++) {
		if (headline.get(i).getCssValue("color").equals("rgba(0, 0, 0, 1)")) {
			System.out.println("----------- news link: "+i+" -----------");
			System.out.println("color is :"+headline.get(i).getCssValue("color"));
		}else {System.err.println("color is not equals to black"+headline.get(i).getCssValue("color"));
		}
	}
	  
	  
  }
  @Test (groups = "headline")
  public void test3() {
	  List<WebElement> headline=driver.findElements(By.xpath("//div[8]/div//div[1]/div[6]/div[2]/span//div/div[2]/div[2]/div//div//div[1]/a/span"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  for (int i = 0; i < headline.size(); i++) {
			System.out.println("----------- news link: "+i+" -----------");
		if (headline.get(i).getCssValue("font-weight").equals("700")) {
			System.out.println("the text is :"+headline.get(i).getCssValue("font-weight"));
		}else {System.err.println("the text is bold"+headline.get(i).getCssValue("font-weight"));
		}
	}  
  }
  @Test (groups = "credit")
  public void test4() {
	  List<WebElement> credit=driver.findElements(By.xpath("//div[8]/div//div[1]/div[6]/div[2]/span/div//div[2]/div[2]/div//div//div[2]/span[1]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  for (int i = 0; i < credit.size(); i++) {
			System.out.println("----------- credits of articles: "+i+" -----------");
		if (credit.get(i).getCssValue("font-size").equals("12px")) {
			System.out.println("the size is :"+credit.get(i).getCssValue("font-size"));
		}else {System.err.println("the size is no equals to 12px"+credit.get(i).getCssValue("font-size"));
		}
	}  
  }
  @Test (groups = "credit")
  public void test5() {
	  List<WebElement> credit=driver.findElements(By.xpath("//div[8]/div//div[1]/div[6]/div[2]/span/div//div[2]/div[2]/div//div//div[2]/span[1]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  for (int i = 0; i < credit.size(); i++) {
			System.out.println("----------- credits of articles: "+i+" -----------");
		if (credit.get(i).getCssValue("color").equals("rgba(153, 153, 153, 1)")) {
			System.out.println("the color is :"+credit.get(i).getCssValue("color"));
		}else {System.err.println("the size is no gray "+credit.get(i).getCssValue("color"));
		}
	}  
  }
  @Test (groups = "credit")
  public void test6() {
	  List<WebElement> credit=driver.findElements(By.xpath("//div[8]/div//div[1]/div[6]/div[2]/span/div//div[2]/div[2]/div//div//div[2]/span[1]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  for (int i = 0; i < credit.size(); i++) {
			System.out.println("----------- credits of articles: "+i+" -----------");
		if (credit.get(i).getCssValue("font-family").equals("arial")) {
			System.out.println("the font-family is :"+credit.get(i).getCssValue("font-family"));
		}else {System.err.println("the font-family is no arial "+credit.get(i).getCssValue("font-family"));
		}
	}  
  }
  @Test (groups = "img")
  public void test7() {
	  WebElement img=driver.findElement(By.xpath("//div[8]/div//div[1]/div[6]/div[2]/span/div//div[2]/div[1]/div//div//div[3]/div//span/a/img"));
	  int w =img.getSize().getWidth();
	  int h =img.getSize().getHeight();
	  if (h==84 && w==150) {
		  System.out.println("the width of big img ok");
		  System.out.println("the Height of big img ok");
	}else {
		  System.err.println("the width of big img not ok");
		  System.err.println("the Height of big img not ok");
	}
	
	
  }
  @Test (groups = "logo")
  public void test8() {
	  WebElement logo=driver.findElement(By.xpath("//div[8]/div//div[1]/div[2]/div/span/div//div[2]/div/a/img"));
	  Point point = logo.getLocation();
	  int x =point.getX();
	  int y =point.getX();
	  if (x==1047 && y==1047) {
		  System.out.println("the x point of logo ok");
		  System.out.println("the y point of logo ok");
	}else {
		  System.err.println("the x point of logo not ok");
		  System.err.println("the y point of logo not ok");
	}
	
	
  }
}
