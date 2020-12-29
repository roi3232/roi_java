package selenium_project;

import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class weekend {
	public static void wk(WebDriver driver, Robot robot) throws IOException {
		try {
			driver.get("https://my.weekend.co.il/%D7%A0%D7%A7%D7%95%D7%93%D7%AA_%D7%97%D7%9F/");
			double value = 0.0;
			List<WebElement> rating = driver.findElements(By.cssSelector("div[class='gradesshort']"));
			// הדפסת ציונים
			System.out.println("Rating are:");
			for (int i = 0; i < rating.size(); i++) {
				System.out.println(rating.get(i).getText().replace("מתוך 5", ""));
				value += Double.parseDouble(rating.get(i).getText().replace("מתוך 5", ""));
			}
			// חישוב ממוצא של הערכים של הציונים
			First_stage_func.avgValues(value, rating);
			First_stage_func.screenShot3(robot);
			System.out.println("תרגיל 4 הצליח");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.err.println("תרגיל 4 נכשל");
		}
		//
	}
	//
}
