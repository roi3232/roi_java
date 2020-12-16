package Object__Repository;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

public class Object_Repository_t {
	public static WebDriver driver;


	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException  {
		Object_Repository_cunfig or=new Object_Repository_cunfig(driver);
		int bowserNum=1;
		int categoryNum=1;
		
		while (bowserNum<=3) {
			driver=or.browser(driver, or.getData("brwser"+bowserNum));
			driver.manage().window().maximize();
			driver.switchTo().window(driver.getWindowHandle());
			while (categoryNum<=3) {
				driver.get("https://www.d.co.il/");
				driver.findElement(By.id("query")).sendKeys(or.getData("category"+categoryNum));
				driver.findElement(By.className("search_submit")).click();
				System.out.println(driver.getTitle());
				categoryNum++;
			}
			bowserNum++;
			driver.close();
			


		}
		
//
	}
//
}
