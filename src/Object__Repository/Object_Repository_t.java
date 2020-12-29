package Object__Repository;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.xml.sax.SAXException;

public class Object_Repository_t {
	public static WebDriver driver;
	static String browserName;
	static Capabilities cap;

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		Object_Repository_cunfig or = new Object_Repository_cunfig(driver);
		int bowserNum = 1;
		while (bowserNum <= 3) {
			int categoryNum = 1;
			driver = or.browser(driver, or.getData("brwser" + bowserNum));
			driver.manage().window().maximize();
			while (categoryNum <= 3) {
				driver.get("https://www.d.co.il/");
				WebElement query = driver.findElement(By.id("query"));
				query.sendKeys(or.getData("category" + categoryNum));
				String queryString = query.getAttribute("value");
				driver.findElement(By.className("search_submit")).click();
				if (queryString.equals("מוניות")) {
					Thread.sleep(2000);
					driver.findElement(By.className("skip")).click();
					System.out.println(driver.getTitle());
					cap = ((RemoteWebDriver) driver).getCapabilities();
					browserName = cap.getBrowserName().toLowerCase();
					System.out.println(browserName);
				} else {
					Thread.sleep(2000);
					System.out.println(driver.getTitle());
					cap = ((RemoteWebDriver) driver).getCapabilities();
					browserName = cap.getBrowserName().toLowerCase();
					System.out.println(browserName);
				}
				categoryNum++;
			}
			bowserNum++;
			driver.close();
		}
//
	}
//
}
