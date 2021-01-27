package excel_csv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class t6_1 {
	public static List<String> readCsv(int num) throws IOException {
		List<String> lines = new ArrayList<String>();
		File file = new File("C:\\Users\\royko\\Documents\\אוטומציה\\csv.csv");
		lines = FileUtils.readLines(file, "windows-1255");
		return lines;
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeDriver driver = new ChromeDriver();
		List<String> line = readCsv(4);

		for (int i = 1; i < line.size(); i++) {
			String[] split = line.get(i).split(",");

			driver.get("http://danielauto.net/practice/loginPage/loginpageTest.html");
			driver.findElement(By.id("uaertName")).sendKeys(split[0]);
			driver.findElement(By.id("password")).sendKeys(split[1]);
			driver.findElement(By.id("send")).click();
			if (split[2].equals("fals")) {
				try {
					driver.findElement(By.id("err")).getText();
					System.out.println(" הבדיקה  " + i + " הצליחה");
				} catch (Exception e) {
					System.err.println(" הבדיקה  " + i + "לא הצליחה");
				}

			} else {
				try {
					driver.findElement(By.tagName("h1")).getText();
					System.out.println(" הבדיקה  " + i + " הצליחה");
				} catch (Exception e) {
					System.err.println(" הבדיקה  " + i + " לא הצליחה");
				}
			}
		}
		driver.close();
	}
}
