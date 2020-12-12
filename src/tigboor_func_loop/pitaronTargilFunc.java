package tigboor_func_loop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pitaronTargilFunc {


	
	static List<WebElement> page;
	
	public static List<WebElement> list(WebDriver driver) {
		List<WebElement> list =  driver.findElements(By.xpath("//div[@class='article']//h1"));
		return list;
	}
	
	public static List<WebElement> page(WebDriver driver) {
		List<WebElement>page = driver.findElements(By.xpath("//div[@class='pagination-centered']//a[@class='pageLink']"));	
		return page;
	}
	public static void printPage(int i) {
		System.out.println("--- page : " + (i+1) + " ---");
	}
}
