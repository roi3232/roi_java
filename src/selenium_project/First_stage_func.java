package selenium_project;

import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class First_stage_func {
	public static void isSelected(WebDriver driver, WebElement month) {
		if (month.isSelected()) {
			System.out.println("חשב לפי:"+"isslected");
		}
	}

	public static void error(WebDriver driver, WebElement mailerror, WebElement phonnum, WebElement condiElement) {
		try {
			if (mailerror.isDisplayed()) {
				System.err.println("יש להזין כתובת מייל");
			}
			if (phonnum.isDisplayed()) {
				System.err.println("יש להזין מספר טלפון");
			}
			if (condiElement.isDisplayed()) {
				System.err.println("יש לאשר את תנאי השימוש");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void chakedElement(WebElement chakedElement) {
		try {
			if (!chakedElement.isSelected()) {
				chakedElement.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listen(WebDriver driver, String lang) throws InterruptedException {
		WebElement voiceBtn = driver.findElement(By.xpath("//c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[2]/div[5]/div/div[4]/div[1]/div[2]/div/span/button"));
		Thread.sleep(1500);
		try {
			if (voiceBtn.isEnabled()) {
				voiceBtn.click();
				System.out.println("The " + lang + " played");
				Thread.sleep(1000);
			} else if (!voiceBtn.isEnabled()) {
				System.out.println("The " + lang + " language can't be played");
			}
		} catch (Exception e) {
		}
	}

	public static void vilaNames(WebDriver driver, List<WebElement> result) {
		try {
			for (int i = 0; i < result.size(); i++) {
				String name = result.get(i).getText();
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void avgValues(double value, List<WebElement> rating) {
		try {
			double avgValues = value / rating.size();
			System.out.println("Avrage of rating:" + new DecimalFormat("#.##").format(avgValues));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void screenShot(Robot robot) throws IOException {
		try {
			BufferedImage screenShot = robot
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(screenShot, "JPG", new File("C:\\screen_project\\targil_1.jpg"));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void screenShot2(Robot robot) throws IOException {
		try {
			BufferedImage screenShot = robot
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(screenShot, "JPG", new File("C:\\screen_project\\targil_3.jpg"));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void screenShot3(Robot robot) throws IOException {
		try {
			BufferedImage screenShot = robot
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(screenShot, "JPG", new File("C:\\screen_project\\targil_4.jpg"));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void screenShot4(Robot robot) throws IOException {
		try {
			BufferedImage screenShot = robot
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(screenShot, "JPG", new File("C:\\screen_project\\targil_4.jpg"));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//
}