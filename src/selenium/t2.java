package selenium;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class t2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        try {
			driver.get("https://www.calauto.co.il/heb/wantbuy/searchresults/");
			List<WebElement> list =new ArrayList<WebElement>();
			list=driver.findElements(By.xpath("//tr[@class='group']//td[@class='year ng-binding']"));
			
			int year;
			int counter =0;
			String [] arr;
			
			for (int i=0;i<list.size();i++) {
//		System.out.println(list.get(i).getText());
				if (list.get(i).getText().contains("-")) {
					arr=list.get(i).getText().split("-");
					for (String b:arr) {
						year=Integer.parseInt(b.trim());
						if (year>2012) {
							System.out.println(year+"גדול 2012");
						}else {
							System.out.println(year+"מ-2012 קטן");
							counter++;
						}
					}
				}
				
				if (!list.get(i).getText().contains("-")) {
					arr=list.get(i).getText().split("-");
					for (String b:arr) {
						year=Integer.parseInt(b.trim());
						if (year>2012) {
							System.out.println(year+"גדול 2012");
						}else {
							System.out.println(year+"מ-2012 קטן");
							counter++;
						}
					}
				}
				
			}
			System.out.println("מספר הרכבים משנתון פחות מ-2012:"+counter);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(driver); 
        //תרגיל סטימצקי
        
        try {
			driver.get("https://www.steimatzky.co.il/");
			driver.findElement(By.id("search")).sendKeys("הטיגריס הלבן");
			driver.findElement(By.xpath("//div[@id='headerSearch']//input[@type='submit']")).click();
			System.out.println(driver.findElement(By.xpath("//h2[@class='authorTitle']//a")).getText());
			System.out.println(driver.findElement(By.xpath("//div[@class='normalPrice']//span")).getText());
			System.out.println(driver.findElement(By.xpath("//div[@class='comments-label']//a[1]")).getText());
			System.out.println(driver.findElement(By.xpath("//ul[@class='review-list']//li[1]//div/span[1]")).getText());
			System.out.println(driver.findElement(By.xpath("//ul[@class='review-list']//li[2]//div/span[1]")).getText());
			System.out.println(driver.findElement(By.xpath("//ul[@class='review-list']//li[3]//div/span[1]")).getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.quit();

        //תזמון לאחר 10 שניות
        
try {
	driver.get("https://www.google.co.il/maps/@31.8910642,35.0057688,15z?hl=iw");
	driver.findElement(By.id("searchboxinput")).sendKeys("מודיעין");
	driver.findElement(By.id("searchbox-searchbutton")).click();
	Thread.sleep(10000);
	System.out.println(driver.findElement(By.xpath("//div[@id='pane']//h1/span[1]")).getText());
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

        //יחכה היא הרבה 10 שניות
       
        try {
			driver.get("https://www.google.co.il/maps/@31.8910642,35.0057688,15z?hl=iw");
			driver.findElement(By.id("searchboxinput")).sendKeys("מודיעין");
			driver.findElement(By.id("searchbox-searchbutton")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
			System.out.println(driver.findElement(By.xpath("//div[@id='pane']//h1/span[1]")).getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // יחכה הכי הרבה 10 שניות אבל במקרה והאלמט מופיע אז הוא ימשיף
        
        try {
			driver.get("https://www.google.co.il/maps/@31.8910642,35.0057688,15z?hl=iw");
			driver.findElement(By.id("searchboxinput")).sendKeys("מודיעין");
			driver.findElement(By.id("searchbox-searchbutton")).click();
			WebElement myWebElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='pane']//h1/span[1]")));
			System.out.println(driver.findElement(By.xpath("//div[@id='pane']//h1/span[1]")).getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        //דוגמה להחלפת טאב ובחזרה
       
        try {
			driver.get("http://danielauto.net/practice/usefull/useful1.html");
			driver.findElement(By.id("NewTab")).click();
			ArrayList<String> tabs2= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(tabs2.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //דוגמה ךמעבר למסדרת ובחזרה
        try {
			driver.get("http://tiran-bank.co.il/%d7%9e%d7%97%d7%a9%d7%91%d7%95%d7%9f-%d7%94%d7%9e%d7%a8%d7%aa-%d7%9e%d7%98%d7%91%d7%a2/");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"sitemain\"]/section[1]/div/div/div/div[2]/iframe")));
			driver.findElement(By.id("SelectCurrencyAmount")).clear();
			driver.findElement(By.id("SelectCurrencyAmount")).sendKeys("300");
			driver.switchTo().defaultContent();
			System.out.println(driver.findElement(By.xpath("//section//div/h1")).getText());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		close(driver);



	}

	public static void close(WebDriver driver) { 
			
			@SuppressWarnings("resource")
			Scanner cons=new Scanner(System.in);
			System.out.println("press enter to close");
			cons.nextLine();
			driver.quit();
			}
			
		}	

        
        //
	
//

