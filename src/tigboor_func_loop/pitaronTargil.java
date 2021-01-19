package tigboor_func_loop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pitaronTargil {
	static int count = 0;
	static List<WebElement> list;
	static List<WebElement> page;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.sqlink.com/career/db/qa-%D7%AA%D7%95%D7%9B%D7%A0%D7%94/");

		list = driver.findElements(By.xpath("//div[@class='article']//h1"));
		System.out.println(list.size());
		list = pitaronTargilFunc.list(driver);
		System.out.println(list.size());

		page = driver.findElements(By.xpath("//div[@class='pagination-centered']//a[@class='pageLink']"));
		page = pitaronTargilFunc.page(driver);
		System.out.println(page.size());

		for (int i = 0; i < page.size(); i++) {
			List<WebElement> page = pitaronTargilFunc.page(driver);
			pitaronTargilFunc.printPage(i);
			for (int j = 0; j < list.size(); j++) {
				List<WebElement> list = pitaronTargilFunc.list(driver);
				System.out.println(list.get(j).getText());
				count++;
			}
			page.get(i).click();
			Thread.sleep(2000);
		}
		driver.close();
	}
}
