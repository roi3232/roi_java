package selenium;

import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class t4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver=new ChromeDriver();

        try {
        	  driver.get("http://danielauto.net/practice/tabls/tables.html");
              List<WebElement> col=driver.findElements(By.xpath("//table//th"));
              List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
            System.out.println("number of col:"+col.size());
            System.out.println("number of row:"+row.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        try {
        	 driver.get("http://danielauto.net/practice/tabls/tables.html");
             List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
             int a=0, b=0 ,c=0;
 			for (int i = 1; i < row.size(); i++) {
 				String group =  driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[2]")).getText();
 				if (group.equals("A")) {a++;}
 				if (group.equals("B")) {b++;}
 				if (group.equals("C")) {c++;}
 			}
 			System.out.println("group a : " + a + "  group b : " +b +  " group c : " + c );
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        
        try {
        	 driver.get("http://danielauto.net/practice/tabls/tables.html");
        	 List <WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
        	 String max;
        	 double m=0,r=0;
             for (int i =1;i<row.size();i++){
             max= driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[3]")).getText();
             if (max.contains(",")) {
             max = max.replaceAll("," , "");
             }
             m = Double.parseDouble(max);
             if(m>r){
            	 r=m;
            	 }
             }
             System.out.println("Maximum current price is : "+ r);
             } catch (Exception e) {
            	 // TODO: handle exception
            	 }
        
        try {
        	driver.get("http://danielauto.net/practice/tabls/tables.html");					
			List <WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
				String companyName;
			  for (int i =1;i<row.size();i++){    
		            companyName= driver.findElement(By.xpath("//*[@id=\"tab\"]/tbody/tr["+i+"]/td[1]")).getText();
		            if (companyName.matches("(?i)" + Pattern.quote("a") + ".*")) {
						System.out.println(companyName);
					}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        try {
        	driver.get("http://danielauto.net/practice/tabls/tables.html");					
			List <WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
			String companyName;
			String  companyGroup;
		
			  for (int i =1;i<row.size();i++){    
		            companyName= driver.findElement(By.xpath("//*/tbody/tr["+i+"]/td[1]")).getText();
		            companyGroup = driver.findElement(By.xpath("//*/tbody/tr["+i+"]/td[2]")).getText();   
		            if (companyName.matches("(?i)" + Pattern.quote("a") + ".*")) {
		            	if (companyGroup.equalsIgnoreCase("c")) {
		            		System.out.println(companyName);
						}						
					}                     
		        }
		} catch (Exception e) {
			// TODO: handle exception
		}
   try {
	 	driver.get("http://danielauto.net/practice/tabls/tables.html");
	 	Thread.sleep(1000);
			List <WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
			String max;
			 double m=0;
			 double sum=0;
			  for (int i =1;i<row.size();i++){
		            max= driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[5]")).getText();	          
		             max = max.replaceAll("+", "");	            
		             m = Double.parseDouble(max);
		             sum=sum+m;
		        }
		        System.out.println("Total profit in percentages "+ new DecimalFormat("##.##").format(sum));
		        } catch (Exception e) {
		        // TODO: handle exception
		        	}
   
   try {
		driver.get("http://danielauto.net/practice/tabls/tableDynamic.html");
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.xpath("//div[3]/table/tbody"));
		List<WebElement> row_num = table.findElements(By.tagName("tr"));
		for (int i = 0; i < row_num.size(); i++) {
			List<WebElement> call_num = row_num.get(i).findElements(By.tagName("td"));
				int call_sise = call_num.size();                              
				System.out.println(table.findElement(By.xpath("//div[3]/table/tbody/tr["+(i+1)+"]/td["+call_sise+"]")).getText());
				}
		} catch (Exception e) {
			// TODO: handle exception
			}
   
   try {
	   driver.get("http://danielauto.net/practice/tabls/tableDynamic.html");
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.xpath("//div[3]/table/tbody"));
		List<WebElement> row_num = table.findElements(By.tagName("tr"));
		for (int i = 0; i < row_num.size(); i++) {
			List<WebElement> colums = row_num.get(i).findElements(By.tagName("td"));
			int colums_cuont = colums.size();
			for (int j = 0; j < colums_cuont; j++) {
				System.out.println("in the row " + (i+1) + " colum " + (j+1) + " have number " + colums.get(j).getText());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			}
   driver.close();

	}

}
