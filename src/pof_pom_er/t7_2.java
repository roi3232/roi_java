package pof_pom_er;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class t7_2 {
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		 driver=new ChromeDriver();
		
		//הדפסה לקובץ טקסט
		try(
				PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("text.txt",true )))){
				out.println("the text");
		} catch (Exception e) {
		}
		
				//	True	= הוספה לקובץ קיים
			    //False	יצירת קובץ חדש =
		

	}
		
		}
		
