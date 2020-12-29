package Jframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class label3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("http://danielauto.net/practice/action/alert.html");
		driver.findElement(By.id("alert3")).click();
		driver.switchTo().alert().sendKeys("roi");
		driver.switchTo().alert().accept();

		JframeRunner.label4.setText(driver.findElement(By.id("text")).getText());
		driver.quit();

	}

}
