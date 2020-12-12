package selenium_project;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main_class {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		Robot robot = new Robot();
	    supermarker.supermarker1(driver, actions, robot);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Google_Translate.gt(driver, robot);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vila4u.v4(driver, actions, robot);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		weekend.wk(driver, robot);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
		// close(driver);
	}
	
	   @SuppressWarnings("resource") 
	   public static void close(WebDriver driver) {
	   Scanner cons=new Scanner(System.in);
	   System.out.println("press enter to close"); 
	   cons.nextLine();
       driver.quit();
	   }
	
	//
}
