package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc11_CreateNewView {
	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
	// CLick on Account Link
		Thread.sleep(2000);
		driver.findElement(By.id("Account_Tab")).click();;
		System.out.println("Pass: Accounts page is loaded ");
	//Click on Create New view
		driver.findElement(By.xpath("//*[contains(text(),'Create New View')]")).click();
		System.out.println("Pass: create new View link is clicked");
	//Enter details in view name & unique View Name
		driver.findElement(By.id("fname")).sendKeys("Lenova4");
		WebElement viewUnique=driver.findElement(By.xpath("//input[@id='devname']"));
		viewUnique.click();
		System.out.println("Pass:View Name and Unique Vinew names are provided");
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		System.out.println("Pass:Save Button is clicked");
		Select item=new Select(driver.findElement(By.xpath("//select[@class=\"title\"]")));
		item.selectByVisibleText("Lenova4");
		if(driver.findElement(By.xpath("//select[@class=\"title\"]")).isSelected())
		{
			System.out.println("Pass:  added View is displayed");
		}
		else
		{System.out.println("Fail: Newely added View is not displayed");
	}
			driver.close();
	}
}
