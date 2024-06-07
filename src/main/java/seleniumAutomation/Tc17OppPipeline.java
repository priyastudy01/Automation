package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc17OppPipeline {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		Thread.sleep(2000);
	//Click on Opportunities Link
		driver.findElement(By.xpath("//a[@title=\"Opportunities Tab\"]")).click();
		System.out.println("Pass:Opportunities Link is clicked"); 
		//Click non Oppo pipeline
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
		System.out.println("Pass:Opportunity pipeline Link is clicked"); 
		if(driver.getTitle().contains("Opportunity"))
		{
			System.out.println("Pass:Opportunity Pipeline page is loaded");
		}
		else
		{
			System.out.println("Fail:Page is not loaded");
		}
			
      driver.close();
	}

}
