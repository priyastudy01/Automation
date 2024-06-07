package seleniumAutomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc25_NewContact {
	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		Thread.sleep(2000);
		
		//Click on Contact
		driver.findElement(By.id("Contact_Tab")).click();
	System.out.println("PAss:Clicked on Contact Tab");
	
	//Click on New
	driver.findElement(By.xpath("//input[@name=\"new\"]")).click();
	System.out.println("Pass:New Button is clicked");
	
	//Enter Name and Account name
	WebElement name=driver.findElement(By.id("name_lastcon2"));
	name.sendKeys("sonu");
	System.out.println("Pass:Entered Last name");
	
	//Account name Lookup
	driver.findElement(By.id("con4_lkwgt")).click();
	Thread.sleep(2000);
	Set<String>getAllWindows=driver.getWindowHandles();
	String[] getWindow=getAllWindows.toArray(new String[getAllWindows.size()]);
	driver.switchTo().window(getWindow[1]);
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
	//Click Save Button
	driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();
	Thread.sleep(2000);
	if(driver.findElement(By.id("con2_ileinner")).equals(name))
	{
		System.out.println("Pass: Newly created Contact view page is opened");
	}
	else
	{
		System.out.println("Fail:Newly created contact ad view page is opened");
	}
	driver.close();
}
	
	}	


