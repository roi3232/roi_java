package selenium_project;

import java.awt.Robot;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class vila4u {
	public static void v4(WebDriver driver, Actions actions, Robot robot) {
		try {
			driver.get("https://www.vila4u.com/%D7%9B%D7%AA%D7%91%D7%95%D7%AA/%D7%97%D7%95%D7%A4%D7%A9%D7%94_%D7%9C%D7%A4%D7%99_%D7%AA%D7%A7%D7%A6%D7%99%D7%91");
			//בחירת איזור רישום
			driver.findElement(By.id("siteSearch")).sendKeys("וילות בצפון");
			List<WebElement> vila = driver.findElements(By.xpath("//div//div//div//div/div[@class='autoComplete']/span"));
			Thread.sleep(3000);
			vila.get(0).click();
			Thread.sleep(3000);
			//בחירת וילת זוגות
			driver.findElement(By.xpath("//div[1]/section[1]/div//div/form/div[2]/select[1]")).click();
			Thread.sleep(3000);
			List<WebElement> vilaList = driver.findElements(By.xpath("//div[1]/section[1]/div//div/form/div[2]/select[1]/option"));
			vilaList.get(6).click();
			//בחירת איבזור
			driver.findElement(By.xpath("//div[1]/section[1]/div//div/form/div[2]/div[3]/span")).click();
			Thread.sleep(3000);
			List<WebElement> divElement = driver.findElements(By.xpath("//div[1]/section[1]/div//div/form/div[2]/div[3]/div//div"));
			Thread.sleep(3000);
			actions.keyDown(Keys.CONTROL).click(divElement.get(3)).click(divElement.get(5)).keyUp(Keys.CONTROL).build().perform();
			driver.findElement(By.xpath("//div[1]/section[1]/div//div/form/div[2]/div[3]/div/div[@class='ok']")).click();
			//בחירת טווח מחירים
			WebElement minElement = driver.findElement(By.xpath("//div[1]/section[1]/div//div[@class='searchBoxWrap']/form/div[@class='allInputs']/div[@class='priceBoxSearch']/div[2]/a[1]"));
			WebElement maxElement = driver.findElement(By.xpath("//div[1]/section[1]/div//div[@class='searchBoxWrap']/form/div[@class='allInputs']/div[@class='priceBoxSearch']/div[2]/a[2]"));
			actions.dragAndDropBy(minElement, 0, 10).perform();
			actions.dragAndDropBy(minElement, 0, 10).perform();
			actions.dragAndDropBy(minElement, 0, 10).perform();
			actions.dragAndDropBy(minElement, 5, 0).perform();
			actions.dragAndDropBy(maxElement, 93, 0).perform();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("a[class='submitSearch']")).click();
			Thread.sleep(3000);
			// הדפסת  שמות הווילות בתוצאות
			List<WebElement> result = driver.findElements(By.xpath("//div[1]/section[4]/div//div[2]/div//a[@class='vilaName']"));
			First_stage_func.vilaNames(driver, result);
			First_stage_func.screenShot2(robot);
			System.out.println("תרגיל 3 עבר בהצלחה");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("תרגיל 3 נכשל");
		}
	}
}
