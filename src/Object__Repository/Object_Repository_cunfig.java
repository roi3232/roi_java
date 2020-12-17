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
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Object_Repository_cunfig {
	public  WebDriver driver;
	
	public Object_Repository_cunfig(WebDriver driver){
    	this.driver=driver;
    	}
	
	public String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException 
	{
	File fXmlFile = new File("configurtion.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();
	return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}
	public  WebDriver browser(WebDriver driver,String browser) {
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
		    driver=new ChromeDriver();

		}if (browser.equals("ie")) {
			InternetExplorerDriverService.Builder ieDriverService = new InternetExplorerDriverService.Builder().withSilent(true); 
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver","C:\\temp\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(ieDriverService.build());
			
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\temp\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
			driver = new FirefoxDriver();
		}
		
		return driver;
		
	}

}


