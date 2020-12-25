package GmailAPI;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class Gmail {
	static void fileWrite(String text) {
		 try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gmail.txt", true)))) {
			    out.println(text);
		 }catch (Exception e) {
		 }
	}
	static WebDriver driver;
	static String[]multi_addressee ={"roy.koro51@gmail.com"};
	static String toCc = "test@gmail.com";
	//המייל שיוצא ששולח וניתן לרשום מייל לא אמיתי
	static String mailFrom = "roi32.qa@gmail.com";
	static String subject = "test";
	static String file_path = "C:\\Users\\royko\\git\\roi_java\\gmail.txt";
	static String BodyText = "test result";
	static String userName = "roi32.qa@gmail.com";
	static String password = "1A2S3e5t6y";
	static Session session;
	
	

	@BeforeClass
	public static void setUpBeforeClass() {
		
		
		 WebDriverManager.chromedriver().setup();
		 System.setProperty("webdriver.chrome.silentOutput", "true");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://omayo.blogspot.com/search?q=radio");
	}

	@AfterClass
	public static void tearDownAfterClass() throws AddressException, MessagingException {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth ", "true");
		props.put("mail.smtp.port", "465");
		
		session = Session.getDefaultInstance (props,new javax.mail.Authenticator () {
		protected PasswordAuthentication getPasswordAuthentication () {
		return new PasswordAuthentication (userName,password);
		}
		});
		
			try {
				Message message = new MimeMessage (session);
				message.setFrom(new InternetAddress(mailFrom));
				InternetAddress [] addressTo = new InternetAddress[multi_addressee.length];
				for (int i = 0 ; i < multi_addressee.length ; i ++)	{
				message.addRecipient(Message.RecipientType.TO,new
				InternetAddress (multi_addressee [i] ));
				message.addRecipient(Message.RecipientType.CC, new InternetAddress (toCc));
				message.setSubject(subject);
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(BodyText);
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				messageBodyPart	= new MimeBodyPart();
				DataSource source = new FileDataSource (file_path);
				messageBodyPart.setDataHandler(new DataHandler (source));
				messageBodyPart.setFileName(file_path);
				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);
				Transport.send(message);
				System.out.println("message sent");
				}
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		driver.quit();
		}

	@Test
	public void test001() throws InterruptedException {
		WebElement Username=driver.findElement(By.name("userid"));
		WebElement Password= driver.findElement(By.name("pswrd"));
		Username.sendKeys("3333");
		Password.sendKeys("3333");
		WebElement login=driver.findElement(By.xpath("//div[@class='content']/div[@class='content-outer']/div[@class='fauxborder-left content-fauxborder-left']/div[@class='content-inner']/div[@class='main-outer']/div[@class='fauxborder-left main-fauxborder-left']/div[@class='region-inner main-inner']/div/div[@class='columns-inner']/div[@class='column-center-outer']/div//div[7]/div[@class='widget-content']/form/input[@value='Login']"));
		login.click();
		driver.switchTo().alert().accept();
		fileWrite("jklj");
		

		
	}

}
