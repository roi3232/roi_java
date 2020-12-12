package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class t1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        try {
			driver.get("http://danielauto.net/practice/newLocator/locator.html");
			driver.findElement(By.id("myText")).sendKeys("roi");
			driver.findElement(By.id("btn")).click();
			String mytext1 ="roi";
			String mytext = driver.findElement(By.id("myText2")).getText();
			if (mytext1.equals(mytext)) {
				System.out.println("yes");
			}else {
				System.err.println("no");
			}
			driver.navigate().back();
			driver.findElement(By.name("by_Name")).click();
			String a = driver.findElement(By.tagName("h3")).getText();
			String b=driver.findElement(By.tagName("h3")).getText();
			System.out.println(a+" "+b);
			System.out.println(driver.findElement(By.xpath("/html/body/p[5]")).getText());
			driver.findElement(By.linkText("Click me to check link text")).click();
			System.out.println(driver.findElement(By.id("link_text")).getText());
			driver.navigate().back();
			driver.findElement(By.partialLinkText("partial link text")).click();
			System.out.println(driver.findElement(By.id("p_link_text")).getText());
			driver.navigate().back();
			driver.findElement(By.cssSelector("body > p:nth-child(11) > input[type=button]")).click();
			System.out.println(driver.findElement(By.id("btn")).getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.close();
        
        //
	}
//
}
