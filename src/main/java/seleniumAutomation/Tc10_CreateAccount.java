package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc10_CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		//Call Reusable method Log in 
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
	// CLick on Account Link
		driver.findElement(By.id("Account_Tab")).click();;
		System.out.println("Pass: Accounts page is loaded ");
	//Click on New Button
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='btn'])[3]")).click();
		System.out.println("Pass:New Accounts page is loaded ");
	// Enter all inputs
	     WebElement accName= driver.findElement(By.xpath("//input[@id='acc2']"));
	    		 accName.sendKeys("SalesAcc");
	     Select type=new Select(driver.findElement(By.id("acc6")));
	     type.selectByVisibleText("Technology Partner");
	     Select priority=new Select(driver.findElement(By.id("00Nak000001jJim")));
	     priority.selectByVisibleText("High");
	     driver.findElement(By.xpath("(//input[@value=' Save '])[2]")).click();
	     System.out.println("New Accounts Details are entered and save");
	     Thread.sleep(1000);
	     driver.close();

	} 
}
