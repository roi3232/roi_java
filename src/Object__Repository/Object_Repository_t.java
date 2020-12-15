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
		
		or.browser(driver, "chrome");
		driver.get("https://www.d.co.il/");
	
		
		}
		
		
	

}
