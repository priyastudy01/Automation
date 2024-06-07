package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc24New_Leads {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		Thread.sleep(2000);
	
		//Click on Lead Tab
		driver.findElement(By.id("Lead_Tab")).click();
		System.out.println("PAss: Lead page is opened");
		
		//Click on New button
		driver.findElement(By.xpath("//input[@title=\"New\"]")).click();
		System.out.println("Pass:New Button is cliked");
		
		//Enter Last name&Company Name
		WebElement name=driver.findElement(By.id("name_lastlea2"));
		name.sendKeys("ABCD");
		driver.findElement(By.id("lea3")).sendKeys("ABCD");
		System.out.println("Pass: Last & company name entered as ABCD");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();
		if(driver.findElement(By.id("lea2_ileinner")).equals(name))
		{
			System.out.println("Pass: Newly created lead view page is opened");
		}
		else
		{
			System.out.println("Fail:Newly created lead view page is opened\"");
		}
		driver.close();
	}

}
