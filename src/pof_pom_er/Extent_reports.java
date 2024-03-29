package pof_pom_er;

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
import com.aventstack.extentreports.reporter.configuration.Theme;

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
		htmlReporter.config().setDocumentTitle("targil");
		htmlReporter.config().setReportName("test");
		htmlReporter.config().setEncoding("windows-1255");
		htmlReporter.config().setTheme(Theme.DARK);
		return htmlReporter;
	}

	public static ExtentTest createTest(String name, String description) {
		test = extent.createTest("test", "123");
		return test;
	}

	public static ExtentTest createTest1(String name, String description) {
		test1 = extent.createTest("test1", "123");
		return test1;
	}

	public static ExtentTest createTest2(String name, String description) {
		test2 = extent.createTest("test2", "123");
		return test2;
	}

	public static ExtentTest createTest3(String name, String description) {
		test3 = extent.createTest("test3", "123");
		return test3;
	}

	public static ExtentTest createTest4(String name, String description) {
		test4 = extent.createTest("test4", "123");
		return test4;
	}

	public static ExtentTest createTest5(String name, String description) {
		test5 = extent.createTest("test5", "123");
		return test5;
	}

	public static ExtentTest createTest6(String name, String description) {
		test6 = extent.createTest("test6", "123");
		return test6;
	}

	public static ExtentTest createTest7(String name, String description) {
		test7 = extent.createTest("test7", "123");
		return test7;
	}

	public static ExtentTest createTest8(String name, String description) {
		test8 = extent.createTest("test8", "123");
		return test8;
	}

	public String CaptureScreen(WebDriver driver) throws AWTException, IOException {
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("ddHHmmss"));
		String folderPath = ("C:\\test\\" + reportDate);
		String imagePath = folderPath + "/pic" + time + ".jpg";
		Robot robot = new Robot();
		BufferedImage screenShot = robot
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG", new File(imagePath));
		return imagePath;
	}

}
