package selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;



public class t4_1 {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        try {
			driver.get("https://www.jobmaster.co.il/");
			Thread.sleep(5000);
			
				Screen scn=new Screen();
				scn.type("C:\\screen\\1.png","QA");
				if (scn.exists("C:\\screen\\5.png") != null) {
					System.out.println("תמונה קיימת 3");
				}
				scn.click("C:\\screen\\2.png");
				if (scn.exists("C:\\screen\\3.png") != null) {
					System.out.println("תמונה קיימת 1");
				}
				if (scn.exists("C:\\screen\\4.png") != null) {
					System.out.println("תמונה קיימת 2");
				}
				Thread.sleep(1000);
				if ((scn.exists("C:\\screen\\5.png") == null)) {
					System.out.println("תמונה 3 לא קיימת");
				driver.quit();

}
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	}
