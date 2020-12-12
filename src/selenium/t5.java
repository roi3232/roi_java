package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;

public class t5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver=new ChromeDriver();
	
try {
	driver.get("https://myhealth.stanfordhealthcare.org/#/");
	driver.findElement(ByAngular.model("id")).sendKeys("roi");
	driver.findElement(ByAngular.model("password")).sendKeys("123");
	driver.findElement(ByAngular.buttonText("Sign In")).click();
	Thread.sleep(5000);
	driver.quit();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}

}
