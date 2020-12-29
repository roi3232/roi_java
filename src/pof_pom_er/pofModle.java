package pof_pom_er;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class pofModle {

	@FindBy(how = How.ID, using = "searchTxt")
	WebElement searchTxt;
	@FindBy(how = How.ID, using = "Button1")
	WebElement Button1;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td/table//tr[3]/td//form/div[6]//div[2]/div[2]/select/option")
	List<WebElement> result;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td//tbody/tr[3]/td//form/div[6]/div/div[2]/div[3]/table//tr/td[6]/input")
	WebElement add;
	@FindBy(how = How.ID, using = "quantity")
	WebElement quantity;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td//tbody/tr[3]/td//form/div[6]//div[2]/div[4]//tbody/tr[2]/td[10]/a")
	WebElement remove;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td//tbody/tr[3]/td//form/div[6]//div[2]/div[4]//tbody/tr/td[7]")
	List<WebElement> caloris;
	@FindBy(how = How.XPATH, using = "//table//tr[1]/td//tbody/tr[3]/td//form/div[6]//div[2]/div[5]/table//tr[3]/td[1]")
	WebElement sumCaloris;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td/table/tbody/tr[3]//div/form/div[6]//div[2]/div[4]/table//tr[2]/td[8]")
	WebElement Carbo1;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td/table/tbody/tr[3]//div/form/div[6]//div[2]/div[4]/table//tr[3]/td[8]")
	WebElement Carbo2;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td/table/tbody/tr[3]/td//form/div[6]//div[2]/div[5]/table//tr[3]/td[2]")
	WebElement sumCarbo;
	@FindBy(how = How.CLASS_NAME, using = "pager__item")
	List<WebElement> pages;
	@FindBy(how = How.XPATH, using = "//div[2]/div[1]/div/div[3]/main/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[1]")
	List<WebElement> jobs;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/form/div[6]/div/div[2]/div[4]/table/tbody/tr")
	List<WebElement> resultes;

}
