package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class t7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver=new ChromeDriver();
		
		//����� ����� ����� �������
		poModel	pom = new poModel();
		//����� �����  ����� �� ��������
		pom.user(driver).sendKeys("admin");
		pom.pass(driver).sendKeys("123");
		//����� �-POF
		poModel	pof = new poModel();
		pof = PageFactory.initElements (driver, poModel. class);
		pof.user.sendKeys ("��");
		pof.password.sendKeys ("sw");
		pof.btn.click();
		
		
	}

}
