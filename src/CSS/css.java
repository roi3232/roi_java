package CSS;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class css {
	static void fileWrite(String text) {
		 try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("CSS.txt", true)))) {
			    out.println(text);
		 }catch (Exception e) {
		 }
	}
	  static WebDriver driver;

  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  System.setProperty("webdriver.chrome.silentOutput", "true");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.ynet.co.il/home/0,7340,L-8,00.html");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  @Test(groups = "headline")
  public void test1() {
	  List<WebElement> headline=driver.findElements(By.xpath("//div[7]/div/div/div[@class='RelativeElementsContainer site_page_root']/div[6]/div[@class='layoutItem multi-article']/span/div/div[@class='MultiArticleComponenta Standart']/div[@class='slotsContent']/div[2]/div/div/div/div/div[@class='slotTitle']/a/span"));
	  for (int i = 0; i < headline.size(); i++) {
		if (headline.get(i).getCssValue("font-size").equals("14px") && headline.get(i).getCssValue("color").equals("rgba(0, 0, 0, 1)") && headline.get(i).getCssValue("font-weight").equals("700")) {
			fileWrite("----------- news link: "+i+" -----------");
			fileWrite("font size ok");
			fileWrite("font color ok");
			fileWrite("the font is bold");
		}else {
			Assert.assertFalse(headline.get(i).getCssValue("font-size").equals("14px") && headline.get(i).getCssValue("color").equals("rgba(0, 0, 0, 1)") && headline.get(i).getCssValue("font-weight").equals("700"));
		}
		}
	  }
	  

  @Test (groups = "credit")
  public void test2() {
	  List<WebElement> credit=driver.findElements(By.xpath("//div[7]/div/div/div[1]/div[6]/div[2]/span/div/div[@class='MultiArticleComponenta Standart']/div[2]/div[2]/div/div/div/div/div[@class='moreDetails']/span[@class='authorInfo']"));
	  for (int i = 0; i < credit.size(); i++) {
		  fileWrite("----------- Credits of articles: "+i+" -----------");
		if (credit.get(i).getCssValue("color").equals("rgba(153, 153, 153, 1)") && credit.get(i).getCssValue("font-family").equals("arial") && credit.get(i).getCssValue("font-size").equals("12px")) {
			fileWrite("the font is gray");
			fileWrite("the font is arial");
			fileWrite("font size ok");
		}else {
			Assert.assertFalse(credit.get(i).getCssValue("color").equals("rgba(153, 153, 153, 1)") && credit.get(i).getCssValue("font-family").equals("arial") && credit.get(i).getCssValue("font-size").equals("12px"));
			}
		}
	  }

  @Test (groups = "img")
  public void test3() {
	  WebElement img=driver.findElement(By.xpath("/div[7]/div/div/div[1]/div[8]/div[1]/span/div/div/div[2]/div[1]/div/div/div/div/div[@class='mediaArea']/div/div/span/a/img[@class='SiteImageMedia']"));
	  int w =img.getSize().getWidth();
	  int h =img.getSize().getHeight();
	  if (h==84 && w==150) {
		  fileWrite("----------- Size of img -----------");
		  fileWrite("the width of big img ok");
		  fileWrite("the Height of big img ok");
	}else {
		Assert.assertFalse(h==84 && w==150);
		}
	  }
  @Test (groups = "logo")
  public void test4() {
	  WebElement logo=driver.findElement(By.xpath("//div[7]/div/div/div[1]/div[2]/div/span/div/div/div[2]/div/a/img"));
	  Point point = logo.getLocation();
	  int x =point.getX();
	  int y =point.getX();
	  if (x==1702 && y==1702) {
		  fileWrite("----------- Location of logo -----------");
		  fileWrite("the x point of logo ok");
		  fileWrite("the y point of logo ok");
	}else {
		Assert.assertFalse(x==1702 && y==1702);
		}
	  }
  }
