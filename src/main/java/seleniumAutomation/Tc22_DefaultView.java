package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tc22_DefaultView {

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
		view.selectByVisibleText("My Unread Leads");

		//Click on User Menu option 
		WebElement userMenu=driver.findElement(By.xpath("//div[@id=\"userNav\"]"));
		Actions action=new Actions(driver);
		action.moveToElement(userMenu).build().perform();
		userMenu.click();
		System.out.println("Pass: Usermenu is clicked");

		//Click on Logout
		WebElement logOut=driver.findElement(By.xpath("//a[@title=\"Logout\"]"));
		logOut.click();
		System.out.println(" Pass: Logout button is clicked");
		
		//Login
		Thread.sleep(2000);
		driver.get("https://tekarch149-dev-ed.develop.my.salesforce.com//");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("krishpriya@sales.com");
		driver.findElement(By.id("password")).sendKeys("Study_2024");
		Thread.sleep(2000);
		driver.findElement(By.id("Login")).click();
		System.out.println("Pass:Login is successful");
		Thread.sleep(2000);

		//Click on Lead Tab
		driver.findElement(By.id("Lead_Tab")).click();
		System.out.println("PAss: Lead page is opened");
		

		//Click on Go Button
		driver.findElement(By.xpath("//input[@class=\"btn\"][@title=\"Go!\"]")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Go Button");
		
      WebElement Text=driver.findElement(By.id("00Bak0000077GWN_listSelect"));
      
      if(Text.getText().contains("My Unread Leads"))
      {System.out.println("Pass: THe same view page is getting displayed");}
      else {
    	  System.out.println("Fail: Unlead view page is not getting displayed");  
      }
      driver.close();
    	  
	}
	}


