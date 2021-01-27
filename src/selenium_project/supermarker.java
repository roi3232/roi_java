package selenium_project;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class supermarker {

    public static void supermarker1(WebDriver driver, Actions actions, Robot robot) {
        try {
            driver.get("https://www.supermarker.themarker.com/");
        	//חיפוש מחשבון משכנתא
            driver.findElement(By.id("txtSearch")).sendKeys("מחשבון");
            Thread.sleep(2000);
            WebElement autoElements = driver.findElement(By.id("ui-id-1"));
            List<WebElement> list = autoElements.findElements(By.tagName("li"));
            list.get(1).click();
            //בדיקה שנבחר "חשב לפי"
            WebElement month = driver.findElement(By.xpath("//table[@id='mortgageCalculatorType']//input[@id='rblSelectCalcType_0']"));
            First_stage_func.isSelected(driver, month);
            //שליפת טקסט מחלון  שפויע בסימן שאלה
            WebElement qmark = driver.findElement(By.xpath("//table[@id='mortgageCalculatorType']//img"));
            actions.moveToElement(qmark).perform();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement winElement = driver.findElement(By.cssSelector("img[class='titleImg']"));
            String titleText = winElement.getAttribute("alt");
            System.out.println(titleText);
            // בחירת קרן שווה
            WebElement kElement = driver.findElement(By.xpath("//form/div[@id='main']/div[@id='mainContainer']/div[@class='main']/div[1]/div[2]/table[1]/tbody/tr[3]/td[@id='tbKeren']/span/label[@class='ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left']/span"));
            actions.moveToElement(kElement).click().perform();
            // בחירת ללא הצמדה
            WebElement noElement = driver.findElement(By.xpath("//form/div[@id='main']/div[@id='mainContainer']/div[2]/div[1]/div[2]/table[1]/tbody/tr[4]/td[2]/span/label[1]/span"));
            actions.moveToElement(noElement).click().perform();
            // הזנת סכום משכנתא
            WebElement amounElement = driver.findElement(By.id("txtLoanAmount"));
            amounElement.clear();
            amounElement.sendKeys("500000");
            // בחירת תקופת המשכנתא
            WebElement dragElement = driver.findElement(By.xpath("//form/div[@id='main']/div[@id='mainContainer']/div[2]/div[1]/div[2]/table[2]/tbody/tr[3]/td[3]/div/div/span"));
            actions.dragAndDropBy(dragElement, 35, 0).perform();
            //הקלדת שדה ריבית
            WebElement rivElement = driver.findElement(By.id("txtInterest"));
            rivElement.clear();
            rivElement.sendKeys("3.75");
            // לחיצה על חשב
            driver.findElement(By.id("ibCalc")).click();
            Thread.sleep(1000);
            // העתקה סכום הלוואה
            WebElement sumElement = driver.findElement(By.xpath("//form/div[5]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]"));
            actions.click(sumElement).click().perform();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_C);
            WebElement pastElement = driver.findElement(By.id("txtEmail"));
            pastElement.click();
            //הדבקת סכום בשדה המייל
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            driver.findElement(By.id("txtShemPrati")).sendKeys("���� ����");
            WebElement chakedElement = driver.findElement(By.id("3136"));
            // בדיקה עם מסומן הצ'קבוקס  ועם לא לוחת עליו 
            First_stage_func.chakedElement(chakedElement);
            driver.findElement(By.id("btnSendLid")).click();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // בדיקה שמפויע הודעות שגיאה
            WebElement mailerror = driver.findElement(By.xpath("//form/div[@id='main']//div[@class='topLeft']//div[@id='getOffer']/table//tbody/tr[2]//label[@class='error']"));
            WebElement phonnum = driver.findElement(By.xpath("//form/div[@id='main']//div[@class='topLeft']//div[@id='getOffer']/table//tbody/tr[3]//label[@class='error']"));
            WebElement condiElement = driver.findElement(By.xpath("//form/div[@id='main']//div[@class='topLeft']//div[@id='getOffer']/table//tbody/tr[7]//label"));
            First_stage_func.error(driver, mailerror, phonnum, condiElement);
            First_stage_func.screenShot(robot);
            System.out.println("תרגיל 1 עבר בהצלחה");
        } catch (Exception e) {
            System.err.println("תרגיל 1 נכשל");
        }
    }
    //
}
//
