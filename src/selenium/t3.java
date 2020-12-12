package selenium;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class t3 {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
   //פקודה  לגדלת למסך מלא
        try {
			driver.get("http://danielauto.net/practice/usefull/useful1.html");
     driver.manage().window().maximize();
			driver.findElement(By.id("alert1")).click();
			driver.switchTo().alert().dismiss();
			driver.findElement(By.id("alert2")).click();
			System.out.println(driver.switchTo().alert().getText());
      driver.switchTo().alert().accept();
			//לא עובד בכרום
     driver.findElement(By.id("alert3")).click();
     driver.switchTo().alert().sendKeys("Text");
     driver.switchTo().alert().accept();
   
boolean  isSelect;
isSelect= driver.findElement(By.name("Checked")).isSelected();
if (isSelect) {

}else {	
driver.findElement(By.name("Checked")).click();
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

//
	}
//
}
