package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc23TodaysLead {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		Thread.sleep(2000);
	
		//Click on Lead Tab
		driver.findElement(By.id("Lead_Tab")).click();
		System.out.println("PAss: Lead page is opened");
		
		//Click on 'My unread leads' from the view drop down
		Select view=new Select (driver.findElement(By.id("fcf")));
		view.selectByVisibleText("Today's Leads");
		System.out.println("Pass:Todays lead has chosen from Dopdown" );

		//Click on Go Button
		driver.findElement(By.xpath("//input[@class=\"btn\"][@title=\"Go!\"]")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Go Button");
		
		//Validation
		WebElement Text=driver.findElement(By.id("00Bak0000077GWd_listSelect"));
		
	      if(Text.getText().contains("Today's Leads"))
	      {System.out.println("Pass: Todays's lead page is getting displayed");}
	      else {
	    	  System.out.println("Fail:Todays lead page is not getting displayed");  
	      }
	      
	      driver.close();
		
	}

}
