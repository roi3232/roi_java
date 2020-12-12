package selenium;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class t3_1 {

	public static void main(String[] args) throws IOException, InterruptedException, ATUTestRecorderException {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ATUTestRecorder recorder =new ATUTestRecorder("C:\\screen\\","testvideo-",false);
		recorder.start();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       
        try {
        	StopWatch watch=new StopWatch();
            watch.start();
      	  driver.get("http://marcojakob.github.io/dart-dnd/basic/");
      	double time = watch.getTime()/1000.0;
      	System.out.println(time);
      	  watch.stop();
	        List<WebElement> list1=driver.findElements(By.xpath("//img[@class='document']"));
	        for (int i = 0; i < list1.size(); i++) {
	        	WebElement draggable =list1.get(i);
	        	WebElement droppable =driver.findElement(By.xpath("/html/body/div/div"));
	        	new Actions(driver).dragAndDrop(draggable, droppable).perform();
	        	System.out.println("targil 1 pass");
	        
	        }
	        }	
		 catch (Exception e) {
				System.err.println("targil 1 fail");
				}
		
      
	  try {
		  
		  
		  driver.get("http://danielauto.net/practice/action/multipick.html ");
		  
		  List<WebElement> list = driver.findElements(By.cssSelector("SELECT#city *"));
		  new Actions(driver).keyDown(Keys.SHIFT)
		  .click(list.get(0)) .click(list.get(2)).keyUp(Keys.SHIFT)
		  .perform();
		  
		  Thread.sleep(1000);
		  File scrFile =
		  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scrFile, new File("C:\\screen\\failure.png"));
		   
		  
		  new Actions(driver).keyDown(Keys.CONTROL) .click(list.get(0)) .click(list.get(1))
		  .click(list.get(2)) .click(list.get(4)) .click(list.get(0))
		  .keyUp(Keys.CONTROL).perform(); 
		  Thread.sleep(1000); 
		  File scrFile2 =
		  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scrFile2, new File("C:\\screen\\failure2.png"));
		  System.out.println("targil 2 pass"); } 
	  catch (Exception e) {
		  System.out.println("targil 2 fail"); }
  		 
  		  try {
  		  driver.get("http://danielauto.net/practice/action/multipick.html ");
  		  WebElement doubleClickElement = driver.findElement(By.id("dbl_click"));
  		  Actions action = new Actions(driver);
  		  action.doubleClick(doubleClickElement);
  		  action.perform(); 
  		  Thread.sleep(2000); 
  		  if(driver.findElement(By.id("demo")).getText().
  		  equals("הלחיצה על התמונה עברה בהצלחה")) {
  		  System.out.println("התמונה נלחצה בהצלחה"); 
  		  } else {
  		  System.err.println("התמונה לא נלחצה"); 
  		  }
  		  System.out.println("targil 3 pass");
  		  } 
  		  catch (Exception e) {
  			  System.err.println("targil 3 fail"); 
  			  }
  		  
  		 try {
			 driver.get("http://danielauto.net/practice/action/multipick.html");
		  Actions builder = new Actions(driver);
		  WebElement element =
		  driver.findElement(By.id("over"));
		  builder.moveToElement(element).build().perform();
		  Thread.sleep(1000);
		  WebElement element1 = driver.findElement(By.id("dbl_click"));
		  builder.moveToElement(element1).perform(); 
		  Thread.sleep(1000);
		  builder.moveToElement(element).moveToElement(driver.findElement(By.id("over")
		  )).build().perform();
		  String number =driver.findElement(By.id("demo2")).getText();
		  if (number.equals("2")) {
		  System.out.println("המספר 2 מופיע"); 
		  } else {
		  System.err.println("המספר 2 אינו מופיע"); }
		  System.out.println("targil 4 pass"); 
		  } catch (Exception e) {
		  System.out.println("targil 4 fail"); 
		  }
  		  try {
  			  
			  driver.get("http://danielauto.net/practice/action/multipick.html ");
		 Thread.sleep(3000); 
		 WebElement menu = driver.findElement(By.xpath("//*[@id='mouseover']/button")); 
		 Actions actions = new Actions(driver);
		 actions.moveToElement(menu).perform();
		  Thread.sleep(2000);
		  
		  WebElement submenu = driver.findElement(By.linkText("ynet"));
		  actions.click(submenu);
		  actions.perform();
		  Thread.sleep(2000);
		  System.out.println(driver.getTitle());
		  Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		  ImageIO.write(screenshot.getImage(), "PNG",new File("C:\\screen\\fullpagescrn.png"));
		  
		  System.out.println("targil 5 pass"); 
		  }catch (Exception e) { 
			System.out.println("targil 5 fail"); }
  
  		  try {
  			  
  			  driver.get("http://danielauto.net/practice/action/multipick.html ");
  			Thread.sleep(5000);
  			  WebElement element = driver.findElement(By.id("baby"));
  			  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
  			  Thread.sleep(5000); 
  			  File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  			  FileUtils.copyFile(scrFile2, new File("C:\\screen\\failure10.png"));
  			  System.out.println("targil 6 pass"); } 
  		  catch (Exception e) {
  			  System.err.println("targil 6 fail"); 
  			  }
  		
  		  try {
  			driver.get("http://danielauto.net/practice/action/multipick.html ");
			 WebElement slider = driver.findElement(By.xpath("//div[@id='div1']//input[@id='myRange']"));
      Actions move = new Actions(driver);
      move.dragAndDropBy(slider, 30, 0).build().perform();
      Robot robot=new Robot();
      BufferedImage screenShot =robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
      ImageIO.write(screenShot, "JPG", new File("C:\\screen\\failure3.jpg"));
		} catch (Exception e) {
			
		}
  		  
  		  try {
  			driver.get("http://danielauto.net/practice/action/multipick.html ");
  			WebElement Checked =driver.findElement(By.xpath("//div[@id='logo']//input[@name='notChecked']"));
  			Actions actions=new Actions(driver);
  			actions.click(Checked).perform();
  			boolean isSelect;
  			isSelect=driver.findElement(By.xpath("//div[@id='logo']//input[@name='Checked']")).isSelected();
  			System.out.println(isSelect);
  			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
  		  recorder.stop();
  		  driver.close();
		
		  //
		  }
 //
	}
  

