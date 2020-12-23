package CSS;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
	  for (int i = 0; i < headline.size(); i++) {
		if (headline.get(i).getCssValue("font-size").equals("14px") && headline.get(i).getCssValue("color").equals("rgba(0, 0, 0, 1)") && headline.get(i).getCssValue("font-weight").equals("700")) {
			System.out.println("----------- news link: "+i+" -----------");
			System.out.println("font size ok");
			System.out.println("font color ok");
			System.out.println("the font is bold");
		}else {Assert.assertFalse(headline.get(i).getCssValue("font-size").equals("14px") && headline.get(i).getCssValue("color").equals("rgba(0, 0, 0, 1)") && headline.get(i).getCssValue("font-weight").equals("700"));
		}
		}
	  }
	  

  @Test (groups = "credit")
  public void test2() {
	  List<WebElement> credit=driver.findElements(By.xpath("//div[8]/div//div[1]/div[6]/div[2]/span/div//div[2]/div[2]/div//div//div[2]/span[1]"));
	  for (int i = 0; i < credit.size(); i++) {
			System.out.println("----------- Credits of articles: "+i+" -----------");
		if (credit.get(i).getCssValue("color").equals("rgba(153, 153, 153, 1)") && credit.get(i).getCssValue("font-family").equals("arial") && credit.get(i).getCssValue("font-size").equals("12px")) {
			System.out.println("the font is gray");
			System.out.println("the font is arial");
			System.out.println("font size ok");
		}else {
			Assert.assertFalse(credit.get(i).getCssValue("color").equals("rgba(153, 153, 153, 1)") && credit.get(i).getCssValue("font-family").equals("arial") && credit.get(i).getCssValue("font-size").equals("12px"));
			}
		}
	  }

  @Test (groups = "img")
  public void test3() {
	  WebElement img=driver.findElement(By.xpath("//div[8]/div//div[1]/div[6]/div[2]/span/div//div[2]/div[1]/div//div//div[3]/div//span/a/img"));
	  int w =img.getSize().getWidth();
	  int h =img.getSize().getHeight();
	  System.out.println("----------- Size of img -----------");
	  if (h==90 && w==150) {
		  System.out.println("the width of big img ok");
		  System.out.println("the Height of big img ok");
	}else {
		Assert.assertFalse(h==90 && w==150);
		}
	  }
  @Test (groups = "logo")
  public void test4() {
	  WebElement logo=driver.findElement(By.xpath("//div[8]/div//div[1]/div[2]/div/span/div//div[2]/div/a/img"));
	  Point point = logo.getLocation();
	  int x =point.getX();
	  int y =point.getX();
	  if (x==1047 && y==1047) {
		  System.out.println("----------- Location of logo -----------");
		  System.out.println("the x point of logo ok");
		  System.out.println("the y point of logo ok");
	}else {
		Assert.assertFalse(x==1047 && y==1047);
		}
	  }
  }
