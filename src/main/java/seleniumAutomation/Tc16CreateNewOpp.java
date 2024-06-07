package seleniumAutomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc16CreateNewOpp {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		Thread.sleep(2000);
	
		//Click on Opportunities Link
		driver.findElement(By.xpath("//a[@title=\"Opportunities Tab\"]")).click();
		System.out.println("Pass:Opportunities Link is clicked");
	
		//Click on New opportunity
		driver.findElement(By.xpath("//input[@value=\" New \"]")).click();
	
		//Enter details in Opportunity edit Page
		//String parent=driver.getWindowHandle();
		driver.findElement(By.id("opp3")).sendKeys("LaptopDeals");//Oppo Name
		driver.findElement(By.xpath("(//img[@class=\"lookupIcon\"])[1]")).click();//AccName Lookup
		Thread.sleep(2000);
		Set<String>getAllWindows=driver.getWindowHandles();
		String[] getWindow=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);
		
//		System.out.println(driver.getWindowHandles().size());
//		
//		for(String handle : driver.getWindowHandles()) { 
//		  if(handle != parent) 
//		  {
//			  driver.switchTo().window(handle);
//			  Thread.sleep(2000);
//		      String title=driver.getTitle();
//				System.out.println(title);
//		  }
		      
		//switch to first frame  
	    driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("Global");//Input search field
		driver.findElement(By.xpath("//input[@name=\"go\"]")).click();//click Go
		
		//switch to lookup window
		driver.switchTo().defaultContent();
		
		//switch to insideframe
		driver.switchTo().frame("resultsFrame");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class=\" dataCell \"]")).click(); //Choose the row
		driver.switchTo().window(getWindow[0]);
		
		driver.findElement(By.xpath("//span[@class=\"dateFormat\"]")).click();//Click Date
		Select stage=new Select(driver.findElement(By.xpath("//select[@id=\"opp11\"]")));//Choose Stage
		stage.selectByVisibleText("Prospecting");
		driver.findElement(By.xpath("//input[@id=\"opp12\"]")).sendKeys("10");//Probability
		Select leadSource=new Select(driver.findElement(By.id("opp6")));
		leadSource.selectByVisibleText("Web");
		
		//Primary campaign source
		driver.findElement(By.id(("opp17_lkwgt"))).click(); //lookup clicked
		Thread.sleep(2000);
		Set<String>getAll=driver.getWindowHandles();
		String[] get=getAll.toArray(new String[getAll.size()]);
		driver.switchTo().window(get[1]);
		
		//switch to first frame  
	    driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("*a");//Input search field
		driver.findElement(By.xpath("//input[@name=\"go\"]")).click();//click Go
		
		//switch to lookup window
		driver.switchTo().defaultContent();
				
		//switch to insideframe
		driver.switchTo().frame("resultsFrame");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@class=\" dataCell \"])[1]")).click(); //Choose the row
			driver.switchTo().window(get[0]);
			Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@name=\"save\"])[1]")).click();//Click save button
		driver.close();
	}
	}


