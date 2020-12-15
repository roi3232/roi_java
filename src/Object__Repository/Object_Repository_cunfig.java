package Object__Repository;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Object_Repository_cunfig {
	@SuppressWarnings("unused")
	private  WebDriver driver;
	
	public Object_Repository_cunfig(WebDriver driver){
    	this.driver=driver;
    	}
	
	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException 
	{
	File fXmlFile = new File("C:\\Users\\royko\\Documents\\��������\\configurtion.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();
	return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}
	public  WebDriver browser(WebDriver driver,String string) {
		
		if (string.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
		    driver=new ChromeDriver();

		}if (string.equals("ie")) {
			System.setProperty("webdriver.ie.driver","C:\\temp\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		if (string.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\temp\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		return driver;
		
	}

}


