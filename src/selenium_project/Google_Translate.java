package selenium_project;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Google_Translate {

	public static void gt(WebDriver driver, Robot robot) {
		try {
			driver.get("https://translate.google.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	//הזנת טקסט בטקסט להזנה לתרגום
			driver.findElement(By.xpath("//c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[1]/span/span/div/textarea")).sendKeys("שלום שמי רועי");
				driver.findElement(By.xpath("//c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[5]/button")).click();
				List<WebElement> list = driver.findElements(By.xpath("//c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[3]/c-wiz/div[2]/div/div[3]/div/div[2]/div/div[2]")); 
				for (int i = 102; i <list.size(); i++) {
					String lang =list.get(i).getText(); 
					Thread.sleep(1500);
					list.get(i).click();
					Thread.sleep(1500);
					First_stage_func.listen(driver, lang);
					Thread.sleep(1500);
					driver.findElement(By.xpath("//c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[5]/button")).click();
					}
				First_stage_func.screenShot4(robot);
				System.out.println("תרגיל 2 עבר בהצלחה");
				} catch (Exception e) {
						System.err.println("תרגיל 2 נכשל");
						}
		//
	}
	//
}
