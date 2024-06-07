package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc20_Lead {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		Thread.sleep(2000);
	
		//Click on Lead Tab
		driver.findElement(By.id("Lead_Tab")).click();
		if(driver.getTitle().contains("Home")){
         System.out.println("PAss:Lead Home Page is getting displayed");}
		else {
			System.out.println("Fail:Lead Home Page is not getting displayed");}
		driver.close();
		}

	}


