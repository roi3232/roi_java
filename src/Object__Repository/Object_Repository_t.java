package Object__Repository;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Object_Repository_t {
	static WebDriver driver;
	static Object_Repository_cunfig or;
	static WebElement query;
	static WebElement submit;
	static String[] browser= {"chrome,ie,firefox"};

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Object_Repository_cunfig or =new Object_Repository_cunfig(driver);
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test01()  {
		for (int i = 0; i < browser.length; i++) {
			driver=or.browser(driver, "browser"+i+"").get("https://www.d.co.il/");
			
		}	
		
		
		}
		
		
	

}
