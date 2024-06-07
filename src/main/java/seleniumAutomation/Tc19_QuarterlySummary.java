package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc19_QuarterlySummary {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		Thread.sleep(2000);
		
	//Click on Opportunities Link
		driver.findElement(By.xpath("//a[@title=\"Opportunities Tab\"]")).click();
		System.out.println("Pass:Opportunities Link is clicked"); 
		
	// Select interval and include
		Select interval=new Select(driver.findElement(By.id("quarter_q")));
		interval.selectByVisibleText("Current FQ");
		Select include=new Select(driver.findElement(By.xpath("//select[@id=\"open\"]")));
		include.selectByVisibleText("All Opportunities");
		System.out.println("Pass:Interval & include dropdown Values are chosen");
		
	//Click on Run Report
		driver.findElement(By.xpath("//input[@value=\"Run Report\"]")).click();
		Thread.sleep(1000);
		System.out.println("Pass: Run Report button is clicked");
		
	// Validate the Report Page
		if(driver.getTitle().contains("Opportunity"))
		{
			System.out.println("Pass:Opportunity Report page is loaded");
		}
		else
		{
			System.out.println("Fail:Opportunity Report is not loaded");}
		driver.close();
		

	}

}
