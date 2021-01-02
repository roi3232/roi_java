package steimatzky;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Extent_reports {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest test1;
	public static ExtentTest test2;
	public static ExtentTest test3;
	public static ExtentTest test4;
	public static ExtentTest test5;
	public static ExtentTest test6;
	public static ExtentTest test7;
	public static ExtentTest test8;


	public static ExtentHtmlReporter htmlReporter;
	public WebDriver driver;

	public Extent_reports(WebDriver driver) {
		this.driver = driver;
	}

	static DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	static Date today = Calendar.getInstance().getTime();
	static String reportDate = df.format(today);
	public static String filePath = "C:\\test\\" + reportDate + "\\exReport.html";

	public static ExtentReports GetExtent() {
		new File("C:\\test\\" + reportDate).mkdirs();
		if (extent != null)
			return extent;
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		return extent;
	}

	private static ExtentHtmlReporter getHtmlReporter() {
		htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.config().setDocumentTitle("steimatzky- navi_linkes test");
		htmlReporter.config().setReportName("navi_linkes test");
		htmlReporter.config().setEncoding("windows-1255");
		return htmlReporter;
	}

	public static ExtentTest createTest(String name, String description) {
		test = extent.createTest("mCategoey", "link test");
		return test;
	}

	public static ExtentTest createTest1(String name, String description) {
		test1 = extent.createTest("books and English_Books subCategory", "link test");
		return test1;
	}

	public static ExtentTest createTest2(String name, String description) {
		test2 = extent.createTest("games,Gifts_and_leisure subCategory", "link test");
		return test2;
	}

	public static ExtentTest createTest3(String name, String description) {
		test3 = extent.createTest("music_subCategory", "link test");
		return test3;
	}

	public static ExtentTest createTest4(String name, String description) {
		test4 = extent.createTest("Smartphones and Appliances subCategory", "link test");
		return test4;
	}

	public static ExtentTest createTest5(String name, String description) {
		test5 = extent.createTest("Cosmetics_and_perfumes_subCategory", "link test");
		return test5;
	}

	public static ExtentTest createTest6(String name, String description) {
		test6 = extent.createTest("HOME_subCategory", "link test");
		return test6;
	}

	public static ExtentTest createTest7(String name, String description) {
		test7 = extent.createTest("camping_subCategory", "link test");
		return test7;
	}

	public static ExtentTest createTest8(String name, String description) {
		test8 = extent.createTest("Costumers_club_subCategory", "link test");
		return test8;
	}



	public String CaptureScreen(WebDriver driver) throws AWTException, IOException {
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("ddHHmmss"));
		String folderPath = ("C:\\test\\" + reportDate);
		String imagePath = folderPath + "/pic" + time + ".jpg";
		Robot robot = new Robot();
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG", new File(imagePath));
		return imagePath;
	}

}
