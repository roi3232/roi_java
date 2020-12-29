package pof_pom_er;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class poModel {
	// po
	public WebElement user(WebDriver driver) {
		WebElement user = driver.findElement(By.id("uaertName"));
		return user;
	}

	public WebElement pass(WebDriver driver) {
		WebElement pass = driver.findElement(By.id("passowrd"));
		return pass;
	}

	// pof
	@FindBy(how = How.ID, using = "uaertName")
	static WebElement user;
	@FindBy(how = How.ID, using = "password")
	static WebElement password;
	@FindBy(how = How.XPATH, using = "/html/body/")
	static WebElement btn;
	// קיצור
	@FindBy(id = "username")
	private WebElement userName;
	// שימוש לרשימה של אלמנטים
	@FindBy(tagName = "list")
	private List<WebElement> links;

//

//
}
