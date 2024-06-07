package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc18StuckOppo {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		Thread.sleep(2000);
	//Click on Opportunities Link
		driver.findElement(By.xpath("//a[@title=\"Opportunities Tab\"]")).click();
		System.out.println("Pass:Opportunities Link is clicked"); 
	//Click on stuck opportunities
		driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]")).click();
		System.out.println("Pass: stuck Opportunities Link is clicked"); 
		if(driver.getTitle().contains("Stuck"))
		{
			System.out.println("Pass:Stuck Opportunities page is loaded");
		}
		else
		{
			System.out.println("Fail:Stuck Opportunities is not loaded");}
		driver.close();
	}

}
